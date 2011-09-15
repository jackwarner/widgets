package com.expedia.widgets.client;

import com.google.gwt.user.client.Window;

public class Utility {
	public static void OpenLink(String url, boolean inNewWindow) {
		if (!inNewWindow) {
			parentPage(url);
		} else {
			Window.open(url, "Expedia", "");
		}
	}

	private static native void parentPage(String msg) /*-{
														top.location.href = msg;
														}-*/;

	public native static String escapeURL(String url) /*-{
														return escape(url);
														}-*/;
}
