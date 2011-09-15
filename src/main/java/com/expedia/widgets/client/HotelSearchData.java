package com.expedia.widgets.client;


import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;

public class HotelSearchData implements SearchData {

	private HotelSearchCity searchCity = new HotelSearchCity();
	private HotelCheckInDate checkinDate = new HotelCheckInDate();
	private HotelCheckOutDate checkoutDate = new HotelCheckOutDate();
	private NumberOfAdults numAdults = new NumberOfAdults();
	private NumberOfChildren numChildren = new NumberOfChildren();

	@Override
	public String getSearchUrl() {
		// SearchFormFlightHotel testing = new SearchFormFlightHotel();
		// TODO: i18n DATE FORMAT!

		String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
				+ Configuration.getNetworkTracking().replace("?", "&")
				+ "&finalurl=";
		trackingRedirect = trackingRedirect
				+ Utility.escapeURL(getFinalSearchUrl());

		return trackingRedirect;

	}

	public void setDestinationCity(HotelSearchCity destination) {
		this.searchCity = destination;
	}

	public HotelSearchCity getDestinationCity() {
		return searchCity;
	}

	public HotelCheckInDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(HotelCheckInDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public HotelCheckOutDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(HotelCheckOutDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public NumberOfChildren getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(NumberOfChildren numChildren) {
		this.numChildren = numChildren;
	}

	public NumberOfAdults getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(NumberOfAdults numAdults) {
		this.numAdults = numAdults;
	}

	private String getFinalSearchUrl() {
		String url = Configuration.getPOS().getExpediaBaseUrl()
				+ "/pubspec/scripts/eap.asp?GOTO=HOTSEARCH"
				+ "&CityName="
				+ URL.encode(searchCity.get())
				+ "&InDate="
				+ URL.encode(DateTimeFormat.getFormat(
						Configuration.getPOS().getDateFormat()).format(
						checkinDate.get())
						+ "&OutDate="
						+ URL.encode(DateTimeFormat.getFormat(
								Configuration.getPOS().getDateFormat()).format(
								checkoutDate.get()))
						+ "&NumAdult="
						+ URL.encode(numAdults.get() + "")
						+ "&NumChild="
						+ URL.encode(numChildren.get()));

		return url;
	}

}