package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface LineOfBusinessResources300x250 extends ClientBundle {

	final String FOLDER = "searchform/";
	final String SUBFOLDER_300x250 = "300x250/";
	final String LOGOSFOLDER = "logos/";
	
	final String SUBFOLDER = "lob_icons/";
	

	
	@Source(FOLDER + SUBFOLDER + "plane.png")
	ImageResource flight();
	
	@Source(FOLDER + SUBFOLDER + "hotel.png")
	ImageResource hotel();

	

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
