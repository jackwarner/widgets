package com.expedia.widgets.client;

import java.util.ArrayList;

import com.google.inject.Inject;


public class LineOfBusinessConfiguration {
	private static String defaultHotelSearch = "";
	static private SearchFormConstants localized;
	private PointOfSale pos = PointOfSale.US;
	private String tracking = "";
	private boolean newWindow = false;
	ArrayList<LOBEnum> lobs = new ArrayList<LOBEnum>();

	@Inject
	public LineOfBusinessConfiguration(SearchFormConstants localized) {
		LineOfBusinessConfiguration.localized = localized;
	}

	static public SearchFormConstants getSearchFormConstants() {
		return localized;
	}
	/**
	 * Tells us if the user intends for a custom destination to be set in the search box
	 * @return
	 */
	public static boolean isCustomSearchLocation() {
		if (defaultHotelSearch.length() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	public static String getDefaultSearch() {
		try {
			if (defaultHotelSearch.length() <= 0) {
				return localized.Destination();
			} else {
				return defaultHotelSearch;
			}
		} catch (Exception e) {
			return localized.Destination();
		}
	}

	public void setDefaultHotelSearch(String searchPlace) {
		LineOfBusinessConfiguration.defaultHotelSearch = searchPlace;
	}

	public ArrayList<LOBEnum> getLinesOfBusiness() {
		return lobs;

	}

	public void addLob(LOBEnum lobEnum) {
		if (!lobs.contains(lobEnum)) {
			lobs.add(lobEnum);
		}
	}

	/**
	 * Returns the LOB that should be displayed by default
	 * 
	 * @return
	 */
	public LOBEnum getDefaultLOB() {
		if (lobs.size() > 0) {
			return lobs.get(0);
		}
		return LOBEnum.Hotel;
	}

	public void setPOS(PointOfSale pos) {
		this.pos = pos;

	}

	public void setNetworkTracking(String networkTracking) {
		this.tracking = networkTracking;

	}

	public PointOfSale getPOS() {
		return pos;
	}

	public String getNetworkTracking() {
		return this.tracking;
	}

	public void setOpenLinksInNewWindow(boolean openLinksInNewWindow) {
		this.newWindow = openLinksInNewWindow;

	}

	public boolean getOpenLinksInNewWindow() {
		return this.newWindow;
	}

}
