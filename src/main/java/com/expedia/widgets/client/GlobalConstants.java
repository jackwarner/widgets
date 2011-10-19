package com.expedia.widgets.client;

import com.google.gwt.i18n.client.Constants;


public interface GlobalConstants extends Constants {
	@DefaultStringValue("Flight + Hotel")
	String flightAndHotel();

	@DefaultStringValue("More Offers")
	String moreOffers();

	@DefaultStringValue("Search")
	String search();
}
