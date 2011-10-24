package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import com.expedia.widgets.client.dynamicad.LineOfBusiness;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;



public class DealsEngineApi {
	private static final int DEAL_RANDOMIZATION_COUNT = 2;

	final private HandlerManager handlerManager = new HandlerManager(this);

	final private Integer NUM_RESULTS_PER_DESTINATION;
	private String CITIES;
	final private Double LOW_STAR;
	final private Double HIGH_STAR;
	final private String TRACKING;
	private int EXPEDIA_DESTINATION_COUNT;
	private int LENGTH_OF_STAY = 0;
	private Date checkIn;
	private int count = 0;
	private boolean lowComplete = false;
	private boolean highComplete = false;
	private String failureApiCall = "";
	private boolean hasFailed = false;
	private boolean hasSucceeded = false;
	final private int JSON_TIMEOUT = 10000;
	// the magic here is City -> Star -> HotelEntry
	private LinkedHashMap<String, ArrayList<LineOfBusiness>> lowHotels = new LinkedHashMap<String, ArrayList<LineOfBusiness>>();
	private LinkedHashMap<String, ArrayList<LineOfBusiness>> highHotels = new LinkedHashMap<String, ArrayList<LineOfBusiness>>();
	private LinkedHashMap<String, ArrayList<LineOfBusiness>> mergedHotels = new LinkedHashMap<String, ArrayList<LineOfBusiness>>();
	ArrayList<String> destinationNames = new ArrayList<String>();

	/**
	 * Our flag that tells us if all the necessary calls have completed
	 * successfully
	 */

	/**
	 * 
	 * @param numResultsPerDestination
	 * @param cities
	 * @param lowerStar
	 * @param higherStar
	 */
	@Inject
	public DealsEngineApi(Integer numResultsPerDestination,
			int numberofDestinations, String cities, Double lowerStar,
			Double higherStar, String tracking) {
		NUM_RESULTS_PER_DESTINATION = numResultsPerDestination;
		EXPEDIA_DESTINATION_COUNT = numberofDestinations;
		if (cities != null) {
			cities = cities.replace("%20", "-");
			setDestinationNames(cities);
			CITIES = setInitialCities();
		} else {
			CITIES = null;
		}
		// Can be NULL!
		LOW_STAR = lowerStar;
		HIGH_STAR = higherStar;
		TRACKING = tracking;

	}

	public String setInitialCities() {
		String cities = new String();
		for (int i = 0; i < destinationNames.size(); i++) {
			cities = cities + destinationNames.get(i) + ",";
		}
		return cities;
	}

	public void addApiCompletedHandler(ApiListener handler) {
		handlerManager.addHandler(ApiFailedEvent.getType(), handler);
		handlerManager.addHandler(ApiCompletedEvent.getType(), handler);

	}

	public void getData(Destination replacementCity, Date date,
			int numberNights, boolean resetCalls) {
		hasSucceeded = !resetCalls;
		lowHotels.clear();
		highHotels.clear();
		mergedHotels.clear();
		// user can get data many times, so clear stuff out!

		/*
		 * This "first deal" can be either the "hottest" deal, or an inputed
		 * destination which is useful for when the user of the widget inputs
		 * their own destination
		 */
		LENGTH_OF_STAY = numberNights;
		if (date != null) {
			checkIn = date;
		}

		String cityName = replacementCity.getValue();
		// TODO: Hottest deals as constant/object
		try {
			if (cityName.isEmpty() || cityName.equals("Hottest Deals")) {
				getHottestDeal();
			} else {
				/*
				 * This works because ...
				 * Stevie: MAGIC!!!! :D ...And LOGIC!
				 */
				if (destinationNames.size() > EXPEDIA_DESTINATION_COUNT) {
					destinationNames.remove(0);
					CITIES.replace(
							CITIES.subSequence(0, CITIES.indexOf(",") + 1), "");
				}
				destinationNames.add(0, cityName);
				cityName += "," + CITIES;
				setCities(cityName);
				runDestinations();
			}
		} catch (Exception e) {
			System.err.println("Unable to reload");
		}

	}

	public void getHottestDeal() {

		loadData(getApiUrlHottest(true), true, true);
		loadData(getApiUrlHottest(false), false, true);
	}

	public void runDestinations() {
		if (getCities() == null) {
			loadData(getApiUrl(true), true, false);
		} else {
			loadData(getApiUrl(true), true, false);
			loadData(getApiUrl(false), false, false);
		}
	}

	public String getCities() {
		return CITIES;
	}

	private String getApiUrlHottest(boolean lowStar) {
		// http://dealswebtest-159601886.us-east-1.elb.amazonaws.com/beta/deals/hotels.jsonp?callback=gwtsuccess&numberOfResultsPerDestination=2&isDRR=true&maxStarRating=3&minStarRating=3
		String url = "";

		url = EnvironmentConstants.API_URL + ApiConstants.NUM_RESULTS_TOTAL
				+ "=" + EXPEDIA_DESTINATION_COUNT
				* DEAL_RANDOMIZATION_COUNT + "&"
				+ ApiConstants.IS_DRR + "=true&";
		if (lowStar) {
			url += ApiConstants.MAX_STAR_RATING + "=" + getStar(lowStar);
		} else {
			url += ApiConstants.MIN_STAR_RATING + "=" + getStar(lowStar);
		}
		if (LENGTH_OF_STAY != 0) {
			url += "&" + ApiConstants.NUM_NIGHTS + "=" + LENGTH_OF_STAY;
		}

		if (checkIn != null) {
			DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-dd");
			url += "&" + ApiConstants.CHECK_IN_DATE + "=" + fmt.format(checkIn);
		}

		System.err.println("URL is " + url);
		return url;
	}

	private String getApiUrl(boolean isLowStar) {
		// http://dealswebtest-159601886.us-east-1.elb.amazonaws.com/beta/deals/hotels.jsonp?callback=gwtsuccess&numberOfResultsPerDestination=2&isDRR=true&maxStarRating=3&minStarRating=3
		String url = "";
		if (getCities() == null) {
			url = EnvironmentConstants.API_URL
					+ ApiConstants.NUM_RESULTS_PER_DESTINATION + "="
					+ (getCountOfResultsPerDestination(isLowStar))
					* DEAL_RANDOMIZATION_COUNT + "&"
					+ ApiConstants.NUM_RESULTS_TOTAL + "="
					+ EXPEDIA_DESTINATION_COUNT
					* DEAL_RANDOMIZATION_COUNT + "&"
					+ ApiConstants.IS_DRR + "=true&";
			if (isLowStar) {
				url += ApiConstants.MAX_STAR_RATING + "=" + getStar(isLowStar);
			} else {
				url += ApiConstants.MIN_STAR_RATING + "=" + getStar(isLowStar);
			}
			if (LENGTH_OF_STAY != 0) {
				url += "&" + ApiConstants.NUM_NIGHTS + "=" + LENGTH_OF_STAY;
			}
			if (checkIn != null) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-dd");
				url += "&" + ApiConstants.CHECK_IN_DATE + "="
						+ fmt.format(checkIn);
			}

		} else {
			url = EnvironmentConstants.API_URL
					+ ApiConstants.NUM_RESULTS_PER_DESTINATION + "="
					+ (getCountOfResultsPerDestination(isLowStar))
					* DEAL_RANDOMIZATION_COUNT + "&"
					+ ApiConstants.IS_DRR + "=true&";
			if (isLowStar) {
				url += ApiConstants.MAX_STAR_RATING + "=" + getStar(isLowStar)
						+ "&";
			} else {
				url += ApiConstants.MIN_STAR_RATING + "=" + getStar(isLowStar)
						+ "&";
			}
			if (LENGTH_OF_STAY != 0) {
				url += ApiConstants.NUM_NIGHTS + "=" + LENGTH_OF_STAY + "&";
			}

			if (checkIn != null) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-dd");
				url += ApiConstants.CHECK_IN_DATE + "=" + fmt.format(checkIn)
						+ "&";
			}

			url += ApiConstants.DESTINATION + "=" + getCities();
		}

		System.err.println("URL is " + url);
		return url;
	}

	private Double getStar(boolean isLow) {
		if (isLow) {
			return getLowStar();
		}
		return getHighStar();
	}

	public Double getLowStar() {
		return this.LOW_STAR;
	}

	public Double getHighStar() {
		return this.HIGH_STAR;
	}

	public String getDestinations() {
		return this.CITIES;
	}

	public Integer getCountOfResultsPerDestination(boolean isLowStar) {
		if (NUM_RESULTS_PER_DESTINATION % 2 == 1) {

			// show more high star results
			int baseAmount = (NUM_RESULTS_PER_DESTINATION / 2);
			if (isLowStar) {
				return baseAmount;
			} else {
				return (baseAmount + 1);
			}

		}
		return NUM_RESULTS_PER_DESTINATION;
	}

	private void setCities(String myCities) {
		this.CITIES = myCities.replace(" ", "-");
	}

	public boolean doesHotelExist(Hotel hotel, boolean lowStar) {
		if (lowStar) {
			if (lowHotels.isEmpty()) {
				return false;
			}
			if (lowHotels.containsKey(hotel.getCity())
					&& !hotel.isHottestDeal()) {
				ArrayList<LineOfBusiness> hotels = lowHotels.get(hotel
						.getCity());
				for (int i = 0; i < hotels.size(); i++) {
					if (((Hotel) hotels.get(i)).getHotelId().equals(
							hotel.getHotelId())) {
						return true;
					}
				}
			}
			if (lowHotels.containsKey("Hottest Deals")) {
				ArrayList<LineOfBusiness> hotels = lowHotels
						.get("Hottest Deals");
				for (int i = 0; i < hotels.size(); i++) {
					if (((Hotel) hotels.get(i)).getHotelId().equals(
							hotel.getHotelId())) {
						return true;
					}
				}
			}
		} else {
			if (highHotels.isEmpty()) {
				return false;
			}
			if (highHotels.containsKey(hotel.getCity())
					&& !hotel.isHottestDeal()) {
				ArrayList<LineOfBusiness> hotels = highHotels.get(hotel
						.getCity());
				for (int i = 0; i < hotels.size(); i++) {
					if (((Hotel) hotels.get(i)).getHotelId().equals(
							hotel.getHotelId())) {
						return true;
					}
				}
			}
			if (highHotels.containsKey("Hottest Deals")) {
				ArrayList<LineOfBusiness> hotels = highHotels
						.get("Hottest Deals");
				for (int i = 0; i < hotels.size(); i++) {
					if (((Hotel) hotels.get(i)).getHotelId().equals(
							hotel.getHotelId())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isDestinationFull(String destination, boolean lowStar) {
		if (lowStar) {
			if (!lowHotels.containsKey(destination)) {
				return false;
			}
			if (lowHotels.get(destination).size() >= getCountOfResultsPerDestination(lowStar)) {
				return true;
			}
		} else {
			if (!highHotels.containsKey(destination)) {
				return false;
			}
			if (highHotels.get(destination).size() >= getCountOfResultsPerDestination(lowStar)) {
				return true;
			}
		}
		return false;
	}

	private String getDestination(Hotel hotel, boolean isHottest) {
		if (isHottest) {
			return "Hottest Deals";
		} else {
			return hotel.getCity();
		}
	}

	private void addHotel(Hotel hotel, boolean lowStar, String destination) {
		if (lowStar) {
			if (!lowHotels.containsKey(destination)) {
				ArrayList<LineOfBusiness> hotels = new ArrayList<LineOfBusiness>();
				hotels.add(hotel);
				lowHotels.put(destination, hotels);
			} else {
				lowHotels.get(destination).add(hotel);
			}
		} else {
			if (!highHotels.containsKey(destination)) {
				ArrayList<LineOfBusiness> hotels = new ArrayList<LineOfBusiness>();
				hotels.add(hotel);
				highHotels.put(destination, hotels);
			} else {
				highHotels.get(destination).add(hotel);
			}
		}
	}

	private boolean doesCityExist(String city) {
		ArrayList<LineOfBusiness> hotels = new ArrayList<LineOfBusiness>();
		if (lowHotels.containsKey("Hottest Deals")) {
			hotels.addAll(lowHotels.get("Hottest Deals"));
		}
		if (highHotels.containsKey("Hottest Deals")) {
			hotels.addAll(highHotels.get("Hottest Deals"));
		}

		for (int i = 0; i < hotels.size(); i++) {
			if (((Hotel) hotels.get(i)).getCityName().equals(city)) {
				return true;
			}
		}

		return false;
	}

	private void distributeHotels(JsArray<HotelEntry> jsonHotels,
			boolean lowStar, boolean isHottest) {
		String myCities = "";
		int cityCount = 0;
		int length = jsonHotels.length();
		ArrayList<Integer> numbers = new ArrayList<Integer>(length);
		for (int i = 0; i < length; i++) {
			numbers.add(i);
		}
		while (!numbers.isEmpty()) {
			Random random = new Random();
			int number = random.nextInt(numbers.size());
			int current = numbers.get(number);
			Hotel currentHotel = new Hotel(jsonHotels.get(current),
					getTracking(), isHottest);

			if (isSavingsZeroPercent(currentHotel)) {
				numbers.remove(number);
				continue;
			}

			if (isDestinationFull(getDestination(currentHotel, isHottest),
					lowStar)) {
				numbers.remove(number);
				continue; // does the current location need more hotels
			}

			if (doesHotelExist(currentHotel, lowStar)) {
				numbers.remove(number);
				continue; // the hotel already exists, so we need to continue;
			}
			if (isHottest && doesCityExist(currentHotel.getCityName())) {
				numbers.remove(number);
				continue;
			}

			addHotel(currentHotel, lowStar,
					getDestination(currentHotel, isHottest));
			if (!myCities.contains(currentHotel.getCity())
					&& cityCount < EXPEDIA_DESTINATION_COUNT) {
				myCities += currentHotel.getCity() + ",";
				cityCount++;
			}
			numbers.remove(number);
		}
		if (getDestinations() == null && !isHottest) {
			setCities(myCities);
			setDestinationNames(myCities);
			loadData(getApiUrl(false), false, false);
		}
	}

	private boolean isSavingsZeroPercent(Hotel hotel) {
		if (hotel.getPercentSavings().compareTo(new Integer("1")) < 0) {
			return true;
		}
		return false;
	}

	public String getFailureApiCall() {
		return failureApiCall;
	}

	private void loadData(final String url, final boolean lowStar,
			final boolean isHottest) {
		JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
		jsonp.setTimeout(JSON_TIMEOUT);
		// this little bit exists for testing when one of the several calls that
		// are made to the API fails
		// its perfectly reasonable that a call to the hottest deals will
		// succeed
		// but that dubai will fail - try to handle that gracefully
		/*
		 * String extra = ""; if (numberOfApiCalls == 3) { extra = "dd"; }
		 */

		jsonp.requestObject(url, new AsyncCallback<Hotels>() {

			@Override
			public void onFailure(Throwable caught) {
				failureApiCall = url;
				hasFailed = true;
				if (!hasSucceeded) {
					handlerManager.fireEvent(new ApiFailedEvent());
					System.err.println("Throwing API Failed Event.");
				}

			}

			@Override
			public void onSuccess(Hotels result) {
				JsArray<HotelEntry> jsonHotels = result.getHotels();
				if (jsonHotels != null) {
					distributeHotels(jsonHotels, lowStar, isHottest);
				} else {
					System.err.println("jsonHotels is null");
				}
				if (isHottest) {
					if ((highHotels.size() == 1) && (lowHotels.size() == 1)) {
						runDestinations();
					} else {
						count = count + 1;
						if (count == 2) {
							if (highHotels.size() == 1 || lowHotels.size() == 1) {
								runDestinations();
							} else {
								addBlankHotel("Hottest Deals");
								runDestinations();
							}
						}
					}
				}
				if (lowStar && !isHottest) {
					lowComplete = true;
				}

				if (!lowStar && !isHottest) {
					highComplete = true;
				}

				if (lowComplete && highComplete) {
					finalLookThrough();
				}
			}
		});
	}

	private void addBlankHotel(String str) {
		ArrayList<LineOfBusiness> hotels = new ArrayList<LineOfBusiness>();
		hotels.add(new Hotel(true, str));
		lowHotels.put(str, hotels);
	}

	private void finalLookThrough() {
		for (int i = 0; i < destinationNames.size(); i++) {
			if (!lowHotels.containsKey(destinationNames.get(i))
					&& !highHotels.containsKey(destinationNames.get(i))) {
				//addBlankHotel(destinationNames.get(i));
			}
		}
		buildArray();
	}

	private void setDestinationNames(String destinations) {
		ArrayList<String> destinationsList = Destinations
				.getDestinationsStrings();
		for (String token : destinations.split(",")) {
			token = properFormatter(token);
			if (destinationsList.contains(token)) {
				destinationNames.add(token);
			}
		}
	}

	private String properFormatter(String oldString) {
		String properFormattedString = "";
		oldString = oldString.toLowerCase().trim();
		for (String token : oldString.split(" ")) {
			try {
				properFormattedString = properFormattedString
						+ token.substring(0, 1).toUpperCase()
						+ token.substring(1) + " ";
			} catch (Exception e) {
				GoogleAnalytics.trackApiZeroResults();
				System.err.println("No data returned from Deals Engine.");
			}
		}
		return properFormattedString.trim();
	}

	private void resetBooleans() {
		lowComplete = false;
		highComplete = false;

	}

	/**
	 * Once all the async calls are complete, we can build an array that will be
	 * returned to other classes for use.
	 */
	private void buildArray() {
		try {
			resetBooleans();
			ArrayList<LineOfBusiness> highAndLowHotelsForDestination = new ArrayList<LineOfBusiness>();
			if (lowHotels.containsKey("Hottest Deals")) {
				highAndLowHotelsForDestination.addAll(lowHotels
						.get("Hottest Deals"));
			}
			if (highHotels.containsKey("Hottest Deals")) {
				highAndLowHotelsForDestination.addAll(highHotels
						.get("Hottest Deals"));
			}
			if (highHotels.containsKey("Hottest Deals")
					|| lowHotels.containsKey("Hottest Deals")) {
				mergedHotels.put("Hottest Deals",
						highAndLowHotelsForDestination);
			}

			for (int i = 0; i < destinationNames.size(); i++) {
				ArrayList<LineOfBusiness> highAndLowHotelsForDestinations = new ArrayList<LineOfBusiness>();
				if (lowHotels.containsKey(destinationNames.get(i))
						|| highHotels.containsKey(destinationNames.get(i))) {
					if (lowHotels.containsKey(destinationNames.get(i))) {
						highAndLowHotelsForDestinations.addAll(lowHotels
								.get(destinationNames.get(i)));
					}
					if (highHotels.containsKey(destinationNames.get(i))) {
						highAndLowHotelsForDestinations.addAll(highHotels
								.get(destinationNames.get(i)));
					}
					mergedHotels.put(destinationNames.get(i),
							highAndLowHotelsForDestinations);
				}
			}

			if (!hasFailed && !hasSucceeded) {
				hasSucceeded = true;
				handlerManager.fireEvent(new ApiCompletedEvent());

			}
		} catch (Exception e) {

		}
	}

	public HashMap<String, ArrayList<LineOfBusiness>> getDealsForDisplay() {
		if (mergedHotels.size() <= 0) {
			System.err
					.println("Cannot call method before calling Deals Engine API.");
			return null;
		} else {
			return mergedHotels;
		}

	}

	private String getTracking() {
		return this.TRACKING;
	}

	public void clearMergedHotels() {
		mergedHotels.clear();
	}
}
