package com.expedia.widgets.client;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class ExpediaDateSearchFormat {
	protected Date checkInDate = new Date();

	public final String getSearchString() {
		return DateTimeFormat.getFormat("MM/dd/yyyy").format(checkInDate);
	}

	public void set(Date date) {
		checkInDate = date;
	}

	public Date get() {
		return checkInDate;
	}

}

