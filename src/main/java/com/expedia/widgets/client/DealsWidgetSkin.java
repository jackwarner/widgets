package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public interface DealsWidgetSkin extends WidgetSkin {
	public void setLoaderPanel(VerticalPanel loadingPanel);

	public String getNavigationMarkers();

	public Image getStrikeoutImage();

	public Image getFlashlightImage();

	/** The parent style from which all other style inherit **/
	public String getBaseStyleName();

	/**
	 * The parent style name for the offer
	 * 
	 * @return
	 */
	public String getOfferStyleName();

	/**
	 * The style name for the cityLabel
	 * 
	 * @return
	 */
	public String getCityLabelStyleName();

	public String getSearchFormLabelStyleName();

	/**
	 * 
	 * @return
	 */
	public String getHotelStyleName();

	public Stars getStarRating(Double rating);

	public String getStrikePriceStyle();

	public String getOfferPriceStyle();

	public String getPerNightLabel();

	public String getSavingsPercentStyle();

	/**
	 * The color in hex to show in the background of the deal when the user
	 * mouses over a deal.
	 * 
	 * @return
	 */
	public String getOfferMouseOverStyle();

	public boolean hasHeaderImage();

	public boolean hasBackgroundImage();

	

	public Image getRightArrow();

	public Image getLeftArrow();

	public String getDropDown();

	public String getDestinationWidth();

//	public FocusPanel getHeaderImage();

	public Widget getBackgroundImage();

	public int getHeaderTopOffset();

	public Image getBookNowImage();

	public String getBookButtonStyleName();

	public String getTodaysDealsStyle();

	public boolean isBookingButtonHoverable();

	public Image getBookNowImageHover();

	public int getSearchFormWidth();

	public Widget getFailureImage();

	public String getFailureLabelStyleName();

	public String getHotelStyleNameSmall();

	public int getLogoLeftPosition();

}