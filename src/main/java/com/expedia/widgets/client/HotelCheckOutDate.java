package com.expedia.widgets.client;


public class HotelCheckOutDate extends ExpediaDateSearchFormat {

	final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

	public HotelCheckOutDate() {
		checkInDate.setTime(checkInDate.getTime() + MILLIS_IN_DAY);
	}

}
