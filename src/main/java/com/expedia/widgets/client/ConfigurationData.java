package com.expedia.widgets.client;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.Window;

public class ConfigurationData {
	static HashMap<String, List<String>> data = new HashMap<String, List<String>>();

	public final static HashMap<String, List<String>> get() {
		if (Window.Location.getParameterMap() != null) {
			data.putAll(Window.Location.getParameterMap());
			
		} else {
			System.err
					.println("No querystring configuration data found, and no default data provided.");
		}
		return data;
	}
}
