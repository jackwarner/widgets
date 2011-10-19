package com.expedia.widgets.client;

import java.util.Date;


public class SearchFormValues {
	private Destination city = new Destination("", "", true);
	private Date date = null;
	private int nights = 0;

	/**
	 * 
	 * @param city
	 * @param date
	 * @param nights
	 */
	public void set(Destination city, Date date, int nights) {
		this.city = city;
		this.date = date;
		this.nights = nights;
	}

	public void set(Destination city) {
		this.city = city;
	}

	public Destination getCity() {
		return city;
	}

	public Date getDate() {
		return date;
	}

	public int getNights() {
		return nights;
	}

	@Override
	public String toString() {
		return city.getValue() + " - " + date + " " + nights;
	}
}