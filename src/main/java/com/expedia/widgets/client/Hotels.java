package com.expedia.widgets.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


public class Hotels extends JavaScriptObject {
	protected Hotels() {
	}

	public final native JsArray<HotelEntry> getHotels() /*-{
														return this.hotels;
														}-*/;

}
