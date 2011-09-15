package com.expedia.widgets.client;


public class TrackingConstants {
	private String tracking;
	// public static final String URL = "http://" + EnvironmentConstants.ENV_URL
	// + "/TrackingRedirect.aspx";
	public static final String TRACKING_REDIRECT = "http://"
			+ EnvironmentConstants.ENV_URL + "/TrackingRedirect.aspx";

	public String getTracking() {
		return this.tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}
}
