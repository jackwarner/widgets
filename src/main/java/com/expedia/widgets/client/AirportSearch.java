package com.expedia.widgets.client;


public class AirportSearch {
	private String city = "";

	public void set(String city) {
		this.city = city;
	}

	public String get() {
		return UnicodeStrings.LatinToAscii(city);
	}
}