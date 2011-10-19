package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DealsWidgetSkin120x600 implements DealsWidgetSkin {

	final protected Deals120x600Resources resources = GWT
			.create(Deals120x600Resources.class);

	@Override
	public Image getStrikeoutImage() {
		return new Image(resources.strikeout().getSafeUri());
	}

	@Override
	public void setLoaderPanel(VerticalPanel loadingPanel) {
		loadingPanel.add(new Image(resources.expediaLoaderLogo()));
		loadingPanel.add(new Image(resources.loader()));
	}

	@Override
	public String getNavigationMarkers() {
		return "navigationMarkers";
	}

	/** The parent style from which all other style inherit **/
	@Override
	public String getBaseStyleName() {
		return getName();
	}

	public String getName() {
		return "summer";
	}

	/**
	 * The parent style name for the offer
	 * 
	 * @return
	 */
	@Override
	public String getOfferStyleName() {
		return "offer";
	}

	/**
	 * The style name for the cityLabel
	 * 
	 * @return
	 */
	@Override
	public String getCityLabelStyleName() {
		return "cityLabel";
	}

	@Override
	public String getSearchFormLabelStyleName() {
		return "searchFormLabel";
	}

	@Override
	public int getSearchFormWidth() {
		return 1;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getHotelStyleName() {
		return "hotelLabel";
	}

	@Override
	public String getHotelStyleNameSmall() {
		return "hotelLabelSmall";
	}

	@Override
	public Stars getStarRating(Double rating) {
		// this could easily be made configurable, for now, only support bulging
		// stars
		// return new StarsBulging(this, rating, isLarge, showEmptyStars());
		return new StarsFlashlight(this, rating, showEmptyStars());
	}

	@Override
	public boolean showEmptyStars() {
		return true;
	}

	@Override
	public int getAnimatedStarWidth() {
		return 15;
	}

	@Override
	public int getAnimatedStarHeight() {
			return 16;
	}

	@Override
	public Image getFullStar() {
		return new Image(resources.fullStar().getSafeUri());
	}

	@Override
	public Image getHalfStar() {
		return new Image(resources.emptyStar().getSafeUri());
	}

	// TODO: BOTH THESE NEED REAL IMAGES!!!!
	@Override
	public Image getEmptyFullStar() {
		return new Image(resources.emptyStar().getSafeUri());
	}

	@Override
	public Image getEmptyHalfStar() {
		return new Image(resources.halfStar().getSafeUri());
	}

	@Override
	public String getStrikePriceStyle() {
		return "offerPrice";
	}

	@Override
	public String getOfferPriceStyle() {
		return "offerPrice";
	}

	@Override
	public String getPerNightLabel() {
		return "perNightLabel";
	}

	/**
	 * The color in hex to show in the background of the deal when the user
	 * mouses over a deal.
	 * 
	 * @return
	 */
	@Override
	public String getOfferMouseOverStyle() {
		return "mouseOverOffer";
	}

	@Override
	public boolean hasHeaderImage() {
		return true;
	}

	@Override
	public boolean hasBackgroundImage() {
		return true;
	}

	
	@Override
	public Image getRightArrow() {
		return new Image(resources.rightArrow());
	}

	@Override
	public Image getLeftArrow() {
		return new Image(resources.leftArrow());
	}

	@Override
	public String getDropDown() {
		return "dropDown";
	}

	@Override
	public String getDestinationWidth() {

		return "115px";

	}

	@Override
	public String getBookButtonStyleName() {
		return "bookButton2";
	}

	@Override
	public String getTodaysDealsStyle() {
		return "todaysDeals";
	}

	@Override
	public Image getFlashlightImage() {
		return new Image(resources.flashlight());
	}

	@Override
	public Widget getFailureImage() {
		return new Image(resources.failure());
	}

	@Override
	public String getFailureLabelStyleName() {
		return "failure";
	}

	@Override
	public String getClickable() {
		return "clickable";
	}

	@Override
	public int getStarPanelWidth() {
		return 100;
	}

	@Override
	public int getStarPanelHeight() {
		return 20;
	}

	
	
	
	
	
	
	
	@Override
	public String getSavingsPercentStyle() {
		return "savingsPercent";
	}

	@Override
	public Widget getBackgroundImage() {
		return new Image(resources.canvas());
	}

	@Override
	public int getHeaderTopOffset() {
		return 3;
	}

	@Override
	public Image getBookNowImage() {
		return new Image(resources.bookNow());
	}

	@Override
	public boolean isBookingButtonHoverable() {
		return true;
	}

	@Override
	public Image getBookNowImageHover() {
		return new Image(resources.bookNowHover());
	}

	/*@Override
	public Image getBackgroundCanvas() {
		return new Image(resources.canvas());
	}

	@Override
	public Image getBookNowButton() {
		return new Image(resources.bookNow());
	}

	@Override
	public String getDropDown() {
		return "dropDown120x600";
	}
	
	@Override
	public String getOfferPriceStyle() {
		return "offerPriceFourteen";
	}*/

	@Override
	public int getLogoLeftPosition() {
		return 0;
	}

	

	

}
