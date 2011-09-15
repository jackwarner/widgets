package com.expedia.widgets.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class TypeAheadDestinations extends JavaScriptObject {
	protected TypeAheadDestinations() {
	}

	public final native JsArray<TypeAheadDestination> getDestinations() /*-{
																		return this.r;
																		}-*/;
}
