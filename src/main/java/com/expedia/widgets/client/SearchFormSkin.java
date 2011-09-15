package com.expedia.widgets.client;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;


public interface SearchFormSkin extends WidgetSkin {

	public Widget getBackgroundImage();

	public String getBookButtonStyleName();

	public Image getBookNowImage();

	public Image getBookNowImageHover();

	public Image getFlashlightImage();

	@Override
	public String getClickable();

	public Widget getExpediaLogo();

	public Image getSelectorButtonLeft();

	public Image getSelectorButtonRight();

	public Image getSelectorButtonLeftNoArrow();

	public Image getSelectorButtonRightNoArrow();

	public Image getSelectorButtonMiddle();

	public Image getFlightImage();

	public Image getHotelImage();

	public Image getActivities();

	public Image getCar();

	public Image getCruise();

	public Image getFlightCar();

	public Image getFlightHotel();

	public Image getFlightHotelCar();

	public Image getHotelCar();

	public Image getPackageHolidays();

	public String getInputStyle();

	public String getTitleStyle();

	public String getLabelStyle();

	public String getDisabledStyle();

	public CssResource getCss();

	public String getShadowStyle();

	public String getHRStyle();

	public String getBackgroundStyle();

}
