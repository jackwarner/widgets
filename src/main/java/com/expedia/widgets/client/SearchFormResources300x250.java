package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SearchFormResources300x250 extends ClientBundle {

	final String FOLDER = "searchform/";
	final String SUBFOLDER_300x250 = "300x250/";
	final String LOGOSFOLDER = "logos/";
	
	final String SUBFOLDER = "searchform/";
	
	@Source(FOLDER + SUBFOLDER_300x250 + "canvas300x250.png")
	ImageResource canvas300x250();
	
	@Source(FOLDER + "booknow92x33.png")
	ImageResource search92x33();
	
	@Source(FOLDER + "booknow92x33MouseOver.png")
	ImageResource searchMouseOver92x33();
	
	@Source(FOLDER + "flashlight124x33.png")
	ImageResource flashlight();
	
	@Source(LOGOSFOLDER + "expediaLogo.png")
	ImageResource expediaLogoHorizontal135x37();
	
	@Source(FOLDER + SUBFOLDER + "selectorButtonLeft22x49Full.png")
	ImageResource selectorButtonLeft22x49Full();
	
	@Source(FOLDER + SUBFOLDER + "selectorButtonRight22x49Full.png")
	ImageResource selectorButtonRight22x49Full();
	
	@Source(FOLDER + SUBFOLDER + "selectorButtonLeftNoArrow22x49Full.png")
	ImageResource selectorButtonLeftNoArrow22x49Full();
	
	@Source(FOLDER + SUBFOLDER + "selectorButtonRightNoArrow22x49Full.png")
	ImageResource selectorButtonRightNoArrow22x49Full();
	
	@Source(FOLDER + SUBFOLDER + "selectorButtonMiddle50x49Full.png")
	ImageResource selectorButtonMiddle50x49Full();
	
	@Source(FOLDER + SUBFOLDER + "plane.png")
	ImageResource flight();
	
	@Source(FOLDER + SUBFOLDER + "hotel.png")
	ImageResource hotel();
	
	@Source(FOLDER + SUBFOLDER + "searchform300x250.css")
	CssResource myCss300x250();
	

	@Source(FOLDER + SUBFOLDER + "activities.png")
	ImageResource activities();
	
	@Source(FOLDER + SUBFOLDER + "car.png")
	ImageResource car();
	
	@Source(FOLDER + SUBFOLDER + "cruise.png")
	ImageResource cruise();
	
	@Source(FOLDER + SUBFOLDER + "flightCar.png")
	ImageResource flightCar();
	

	@Source(FOLDER + SUBFOLDER + "flightHotel.png")
	ImageResource flightHotel();
	
	@Source(FOLDER + SUBFOLDER + "flightHotelCar.png")
	ImageResource flightHotelCar();
	
	@Source(FOLDER + SUBFOLDER + "hotelCar.png")
	ImageResource hotelCar();
	
	@Source(FOLDER + SUBFOLDER + "packageHolidays.png")
	ImageResource packageHolidays();
}
