package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;


abstract public class Configuration {
	private static final String CLICKTAG_PARAMETER = "clicktag";
	private static final String POINT_OF_SALE_PARAMETER = "pos";
	private static PointOfSale pos = PointOfSale.US;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 250;
	private final String sizeString;
	private static boolean isAnimated = true;

	private static final String SIZE_PARAMETER = "size";
	private static final String PARTNER_PARAMETER = "partner";
	private static final String LAYOUT_PARAMETER = "layout";
	private static final String SKIN_PARAMETER = "skin";
	private static final String WINDOW_PARAMETER = "window";

	private int width;
	private int height;
	protected String widgetName;
	private static boolean openLinksInNewWindow = false;

	private String layoutString = "";
	private String skinString = "";


	private static String queryString;
	final private static TrackingConstants tracking = new TrackingConstants();
	protected HashMap<String, List<String>> mutableMap = new HashMap<String, List<String>>();

	@Inject
	public Configuration(Map<String, List<String>> parameters)
			throws WidgetNameException {

		if (parameters == null) {
			System.err.println("Parameters are null");
			throw new WidgetNameException();
		}
		// System.err.println(parameters.toString());

		Iterator<String> iter = parameters.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			ArrayList<String> arr = new ArrayList<String>();
			if (!ReservedParameters.reserved.contains(key.toLowerCase())) {
				if (key.toLowerCase().equals("locale")) {
					arr.add(parameters.get(key).get(0));
				} else {
					arr.add(parameters.get(key).get(0).toLowerCase().trim());
				}
				mutableMap.put(key.trim().toLowerCase(), arr);
			}
		}

		// System.out.println("Mutable map is :" + mutableMap.toString());

		setWidgetName();
		/*
		 * These strings do not require any further processing
		 */
		// String partnerString =
		// Window.Location.getParameter(PARTNER_PARAMETER);

		List<String> posParamValue = mutableMap.get(POINT_OF_SALE_PARAMETER);
		if (posParamValue != null) {
			try {
				pos = PointOfSale
						.get(posParamValue.get(0).trim().toLowerCase());
				// mutableMap.remove(POINT_OF_SALE_PARAMETER);
				// System.out.println("Processed " + POINT_OF_SALE_PARAMETER +
				// ": " + parameters.toString());
				// System.out.println("Set pos = " + pos.getExpediaBaseUrl());
			} catch (Exception e) {
				System.out.println("Default to US POS");
			}
		}

		/*
		 * We'll create private members based on the values of these strings
		 */

		sizeString = getRequiredParameterValue(mutableMap.get(SIZE_PARAMETER));
		mutableMap.remove(SIZE_PARAMETER);

		String windowString = getOptionalParameterValue(mutableMap
				.get(WINDOW_PARAMETER));
		mutableMap.remove(WINDOW_PARAMETER);

		/*
		 * New window configuration parameter
		 */
		if (windowString == null) {
			openLinksInNewWindow = false;
		} else if (windowString.trim().toLowerCase().equals("new")) {
			openLinksInNewWindow = true;
		} else {
			openLinksInNewWindow = false;
		}

		/*
		 * Handle size parameter (defaults to 300x250
		 */

		if (sizeString != null) {
			if (sizeString.equals("120x600")) {
				width = 120;
				height = 600;
			} else if (sizeString.equals("300x400")) {
				width = 300;
				height = 400;
			} else if (sizeString.equals("130x180")) {
				width = 130;
				height = 180;
			} else if (sizeString.equals("250x250")) {
				width = 250;
				height = 250;
			} else if (sizeString.equals("160x600")) {
				width = 160;
				height = 600;
			} else if (sizeString.equals("400x400")) {
				width = 400;
				height = 400;
			} else if (sizeString.equals("468x60")) {
				width = 468;
				height = 60;
			} else if (sizeString.equals("125x125")) {
				width = 125;
				height = 125;
			} else if (sizeString.equals("300x600")) {
				width = 300;
				height = 600;
			} else {
				width = DEFAULT_WIDTH;
				height = DEFAULT_HEIGHT;
			}
		} else {
			width = DEFAULT_WIDTH;
			height = DEFAULT_HEIGHT;
		}

		/*
		 * Partner tracking
		 */

		skinString = getOptionalParameterValue(mutableMap.get(SKIN_PARAMETER));
		mutableMap.remove(SKIN_PARAMETER);
		layoutString = getRequiredParameterValue(mutableMap
				.get(LAYOUT_PARAMETER));
		mutableMap.remove(LAYOUT_PARAMETER);

		// clean up querystring, not taking into account parameters we already
		// processed
		setPartnerTracking();

	}

	protected void setPartnerTracking() {
		System.out.println("Parameter size of " + mutableMap.size()
				+ " when setting tracking");
		queryString = "?";
		String partnerString = getOptionalParameterValue(mutableMap
				.get(PARTNER_PARAMETER));
		// These are reserved parameters that may not be sent to the tracking
		// redirect
		mutableMap.remove("products");
		Iterator<String> iter = mutableMap.keySet().iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			String value = mutableMap.get(key).get(0);
			if (key.trim().toLowerCase().equals(CLICKTAG_PARAMETER)) {
				value = Utility.escapeURL(value);
			}
			queryString += (key + "=" + value + "&");
			System.out.println("New querystring is: " + queryString);
		}
		System.out.println("Simplified querystring is: " + queryString);

		if (partnerString != null) {
			tracking.setTracking(queryString);
		} else {
			tracking.setTracking("?partner=ola");
		}
	}

	private String getRequiredParameterValue(List<String> parameter)
			throws WidgetNameException {
		String toReturn = "";
		if (parameter != null) {
			toReturn = parameter.get(0);
			if (toReturn == null) {
				throw new WidgetNameException();

			}
			toReturn = toReturn.trim().toLowerCase();
		}
		return toReturn;
	}

	private String getOptionalParameterValue(List<String> parameter) {
		String toReturn = null;
		if (parameter != null) {
			toReturn = parameter.get(0);
			if (toReturn == null) {
				return null;

			}
			toReturn = toReturn.trim().toLowerCase();
		}
		return toReturn;
	}

	public String getSkinString() {
		return skinString;
	}

	public String getLayoutString() {
		return layoutString;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public String getWidgetName() {
		return widgetName;
	}

	public static String getNetworkTracking() {
		return tracking.getTracking();
	}

	public boolean getOpenLinksInNewWindow() {
		return openLinksInNewWindow;
	}

	

	final public String getQueryString() {
		return queryString;
	}

	public String getSizeString() {
		return sizeString;
	}

	/**
	 * Whether or not the widget should be animated
	 */
	final static public boolean isAnimated() {
		return isAnimated;
	}

	public void setAnimated(boolean b) {
		isAnimated = b;

	}

	
	
	/**
	 * Widgets may have primary animation loops, such as looping through cities
	 * in a deal or lines of business in a search form. If they do, this is how
	 * long each item should be shown.
	 * 
	 * As a rule of thumb, anything less than 5 seconds will be too quick and
	 * prove to be an obnoxious addition to any web site.
	 * 
	 * Anything longer than 9 or 12 seconds may fail to be noticed all together.
	 * 
	 * TODO: this might be specfic to Deals Configuration - candidate to move it
	 * there
	 * 
	 * @return
	 */
	
	//This is how many seconds it takes to animate the WHOLE view of offers
	public final static int getAnimationInterval() {
		if (queryString.contains("300x600")) {
			return 18;
		}
		return 12;
	}
	
	
	//This is how long it takes to animate an individual deal
	public final int getDealAnimationInterval() {
		return 2000;
	}


	public static PointOfSale getPOS() {
		return pos;
	}

	abstract public void setWidgetName();
	
	abstract WidgetSkin getSkin();
}
