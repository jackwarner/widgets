package com.expedia.widgets.client;

import com.google.gwt.core.client.JavaScriptObject;

public class TypeAheadDestination extends JavaScriptObject {
	protected TypeAheadDestination() {
	}

	public final native String getName() /*-{
											return this.f;
											}-*/;

	private final native void setName(String name) /*-{
													this.f = f;
													}-*/;
}