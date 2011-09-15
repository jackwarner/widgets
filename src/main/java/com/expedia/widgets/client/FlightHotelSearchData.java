package com.expedia.widgets.client;

import java.util.Date;

import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;


public class FlightHotelSearchData implements SearchData {
	private AirportSearch fromAirport = new AirportSearch();
	private HotelSearchCity searchCity = new HotelSearchCity();
	private HotelCheckInDate checkinDate = new HotelCheckInDate();
	private FlightDepartureTime departingTime = new FlightDepartureTime();
	private HotelCheckOutDate checkoutDate = new HotelCheckOutDate();
	private FlightReturningTime returningTime = new FlightReturningTime();
	private NumberOfAdults numAdults = new NumberOfAdults();
	private NumberOfChildren numChildren = new NumberOfChildren();
	private NumberOfSeniors numSeniors = new NumberOfSeniors();

	@Override
	public String getSearchUrl() {

		String url = Configuration.getPOS().getExpediaBaseUrl()
				+ "/pubspec/scripts/eap.asp?GOTO=PACKAGEWIZ"
				+ "&FrAirport="
				+ URL.encode(fromAirport.get())
				+ "&DestName="
				+ URL.encode(searchCity.get())
				+ "&FromDate="
				+ URL.encode(DateTimeFormat.getFormat(
						Configuration.getPOS().getDateFormat()).format(
						checkinDate.get()))
				+ "&FromTime="
				+ URL.encode(departingTime + "")
				+ "&ToDate="
				+ URL.encode(DateTimeFormat.getFormat(
						Configuration.getPOS().getDateFormat()).format(
						checkoutDate.get())) + "&ToTime="
				+ URL.encode(returningTime.get() + "") + "&NumRooms="
				+ URL.encode("1") + "&NumAdult="
				+ URL.encode(numAdults.get() + "") + "&NumChild="
				+ URL.encode(numChildren.get() + "") + "&NumSenior="
				+ URL.encode(numSeniors.get()) + "&PackageType=2";

		String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
				+ Configuration.getNetworkTracking().replace("?", "&")
				+ "&finalurl=";
		trackingRedirect = trackingRedirect + Utility.escapeURL(url);

		return trackingRedirect;

	}

	public void setFromAirport(String fromAirport) {
		if (fromAirport == null) {
			System.err.println("Warning - trying to set a null airport!");
		}
		this.fromAirport.set(fromAirport);
	}

	public void setToCity(String toCity) {
		this.searchCity.set(toCity);
	}

	public void setDepartDate(Date checkin) {
		this.checkinDate.set(checkin);
	}

	public void setDepartureTime(String time) {
		this.departingTime.set(time);
	}

	public void setReturnDate(Date checkout) {
		this.checkoutDate.set(checkout);
	}

	public void setReturnTime(String time) {
		this.returningTime.set(time);
	}

	public void setNumberOfAdults(String numAdults) {
		this.numAdults.set(numAdults);
	}

	public void setNumberOfChildren(String numChildren) {
		this.numChildren.set(numChildren);
	}

	public void setNumberOfSeniors(String numSeniors) {
		this.numSeniors.set(numSeniors);
	}

}
