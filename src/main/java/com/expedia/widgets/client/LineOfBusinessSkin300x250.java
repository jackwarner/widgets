package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;

public class LineOfBusinessSkin300x250 implements LineOfBusinessSkin {
	
	final protected LineOfBusinessResources300x250 resources = GWT
			.create(LineOfBusinessResources300x250.class); 
	
	@Override
	public Image getFlightImage() {
		return new Image(resources.flight());
	}

	@Override
	public Image getHotelImage() {
		return new Image(resources.hotel());
	}
	
	@Override
	public Image getActivities() {
		return new Image(resources.activities());
	}

	@Override
	public Image getCar() {
		return new Image(resources.car());
	}

	@Override
	public Image getCruise() {
		return new Image(resources.cruise());
	}

	@Override
	public Image getFlightCar() {
		return new Image(resources.flightCar());
	}

	@Override
	public Image getFlightHotel() {
		return new Image(resources.flightHotel());
	}

	@Override
	public Image getFlightHotelCar() {
		return new Image(resources.flightHotelCar());
	}

	@Override
	public Image getHotelCar() {
		return new Image(resources.hotelCar());
	}

	@Override
	public Image getPackageHolidays() {
		return new Image(resources.packageHolidays());
	}
}
