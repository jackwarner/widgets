package com.expedia.widgets.client;

public final class EnvironmentConstants {
	// public static final String ENV_URL = "localhost";
	/**
	 * The URL of the environment - in production, this should always be
	 * "widgets.partners.expedia.com" LocalDev: "localhost" Test:
	 * "test.widgets.partners.expedia.com" Production:
	 * "widgets.partners.expedia.com"
	 */
	public static final String ENV_URL = "widgets.partners.expedia.com";

	/**
	 * The URL of the Deals Engine API
	 */
	public static final String API_URL = "http://deals.expedia.com/beta/deals/hotels.jsonp?";

}
