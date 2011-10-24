package com.expedia.widgets.client;

import com.expedia.widgets.client.dynamicad.LineOfBusiness;
import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;


public class Hotel implements LineOfBusiness {

	private boolean hottestDeal = false;
	private final String tracking;
	private HotelEntry hotel = null;
	private boolean isEmptyHotel = false;
	private String emptyCityName;
	private WidgetMessages messages = GWT.create(WidgetMessages.class);

	@Inject
	public Hotel(String tracking) {
		this.tracking = tracking;
	}
	@Inject
	public Hotel(boolean isEmptyHotel, String name) {
		this.isEmptyHotel = isEmptyHotel;
		emptyCityName = name;
		tracking = "";
	}

	public Hotel(HotelEntry hotel, String tracking, boolean isHottest) {
		this.hotel = hotel;
		this.tracking = tracking;
		this.hottestDeal = isHottest;
	}

	public boolean isHottestDeal() {
		return this.hottestDeal;
	}

	@Override
	/**
	 * Name of the Hotel
	 */
	public String getName() {
		return hotel.getName();
	}

	@Override
	public Double getPrice() {
		// return hotel.getPrice();
		return (hotel.getPromotionAmount() + hotel.getPrice())
				/ hotel.getLengthOfStay();
	}

	public HotelImage getImage(int width, int height) {
		return new HotelImage(unescapeURL(hotel.getImage()), width, height);

	}

	public String getDealType() {
		return hotel.getDealType();
	}

	public Double getStarRating() {
		return new Double(hotel.getStarRating());
	}

	public Double getSalePrice() {

		return new Double(hotel.getPricePerNight());
	}

	/*
	 * public String getNeighorhood() { return hotel.getNeighborhood(); }
	 */
	public Integer getHotelId() {
		return hotel.getHotelId();
	}

	public String getCity() {
		if (isEmptyHotel) {
			return emptyCityName;
		}

		if (isHottestDeal()) {
			return "Hottest Deals";
		}
		return hotel.getCity();
	}

	public String getCityName() {

		return hotel.getCity();
	}

	public String getProductLink() {
		if (hotel.getProductLink() != null) {
			return hotel.getProductLink();
		}
		else {
			System.err.println("Null deeplink for Hotel Offer!");
			return "";
		}
	}

	/**
	 * Rounded Integer of percent savings.
	 * 
	 * @return
	 */
	public Integer getPercentSavings() {
		return new Integer((int) Math.floor(hotel.getPercentSavings()) + "");
	}

	/**
	 * Returned a localized text version of the percent savings for the deal.
	 * 
	 * @return
	 */
	public String getLocalizedPercentSavings() {
		return messages.savings(new Integer((int) Math.floor(hotel
				.getPercentSavings()) + ""));
	}

	@Override
	public String getTracking() {

		String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
				+ this.tracking.replace("?", "&") + "&finalurl=";
		return trackingRedirect + getProductLink();
	}

	public native String unescapeURL(String url) /*-{
													return unescape(url);
													}-*/;

	public boolean isEmptyHotel() {
		return isEmptyHotel;
	}

}
