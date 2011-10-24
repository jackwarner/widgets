package com.expedia.widgets.client;

import com.google.inject.Inject;

public class Destination {
	private final String name;
	private final String value;
	private final boolean enough;

	@Inject
	public Destination(String name, String value, boolean enough) {
		this.name = name;
		this.value = value;
		this.enough = enough;
	}

	/**
	 * The name of the destination as understood by the Global Deals Engine
	 * 
	 * @return Name of the destination as understood by GDE.
	 */
	public String getName() {
		return this.name;

	}

	public String getValue() {
		return this.value;
	}

	public boolean hasEnoughDestinations() {
		return this.enough;
	}
}
