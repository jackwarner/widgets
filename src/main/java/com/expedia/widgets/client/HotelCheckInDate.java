package com.expedia.widgets.client;

import java.util.Date;


public class HotelCheckInDate extends ExpediaDateSearchFormat {

	@Override
	public void set(Date date) {
		this.checkInDate = date;
	}

	@Override
	public Date get() {
		return checkInDate;
	}
}
