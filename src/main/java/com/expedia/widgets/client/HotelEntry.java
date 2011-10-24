package com.expedia.widgets.client;

import com.google.gwt.core.client.JavaScriptObject;

public class HotelEntry extends JavaScriptObject {
	protected HotelEntry() {
	}

	public final native String getName() /*-{
		return this.name;
	}-*/;

	private final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native String getCheckInDate() /*-{
		return this.checkInDate;
	}-*/;

	private final native void setCheckInDate(String checkInDate) /*-{
		this.checkInDate = checkInDate;
	}-*/;

	/**
	 * Get the price.
	 * 
	 * @return
	 */
	public final native double getPrice() /*-{
		return this.baseRate;
	}-*/;

	/**
	 * Sets the price
	 * 
	 * @param baseRate
	 */
	private final native void setPrice(double baseRate) /*-{
		this.baseRate = baseRate;
	}-*/;

	private final native void setLengthOfStay(double lengthofStay) /*-{
		this.lengthofStay = lengthofStay;
	}-*/;

	public final native double getLengthOfStay() /*-{
		return this.lengthofStay;
	}-*/;

	/**
	 * Get sale Price.
	 * 
	 * @return
	 */
	public final native double getPromotionAmount() /*-{
		return this.promotionAmount;
	}-*/;

	public final native double getPricePerNight() /*-{
		return this.pricePerNight;
	}-*/;

	private final native double setPricePerNight(double pricePerNight) /*-{
		this.pricePerNight = pricePerNight;
	}-*/;

	/**
	 * Set sale Price.
	 * 
	 * @return
	 */
	private final native double setPromotionAmount(double promotionAmount) /*-{
		this.promotionAmount = promotionAmount;
	}-*/;

	/**
	 * Get percent savings.
	 * 
	 * @return
	 */
	public final native double getPercentSavings() /*-{
		return this.percentSavings;
	}-*/;

	private final native double setPercentSavings(double percentSavings) /*-{
		this.percentSavings = percentSavings;
	}-*/;

	public final native String getImage() /*-{
		return this.imageUrl;
	}-*/;

	private final native void setImage(String imageUrl) /*-{
		this.imageURL = imageUrl;
	}-*/;

	private final native void setDealType(String destination) /*-{
		this.destination = destination;
	}-*/;

	public final native String getDealType() /*-{
		return this.destination;
	}-*/;

	/**
	 * Get Star Rating
	 * 
	 * @return
	 */
	public final native double getStarRating() /*-{
		return this.starRating;
	}-*/;

	private final native void setStarRating(double starRating) /*-{
		this.starRating = starRating;
		//alert('set stars to' + stars);
	}-*/;

	/**
	 * City
	 */
	public final native void setCity(String destination) /*-{
		this.destination = destination;
	}-*/;

	public final native String getCity() /*-{
		return this.destination;
	}-*/;

	/**
	 * The is the link to the detailed Hotel page on Expedia.com.
	 */
	private final native void setProductLink(String dealDeepLink) /*-{
		this.dealDeepLink = dealDeepLink;
	}-*/;

	public final native String getProductLink() /*-{
		return this.dealDeepLink;
	}-*/;

	/**
	 * Get Hotel Id
	 * 
	 * @return
	 */
	public final native int getHotelId() /*-{
		return this.hotelId;
	}-*/;

	private final native void setHotelId(int hotelId) /*-{
		this.hotelId = hotelId;
	}-*/;

}
