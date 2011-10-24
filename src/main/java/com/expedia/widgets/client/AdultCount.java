package com.expedia.widgets.client;

import com.google.inject.Inject;


public class AdultCount implements SelectionData {

	private String id = "";
	private String name = "";
	
	@Inject
	public AdultCount(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.id;
	}

	@Override
	public void setValue(String value) {
		this.id = value;

	}
}
