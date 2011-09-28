package com.expedia.widgets.client;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

/**
 * @author jackwarner
 * 
 */
public class SearchFormConfiguration extends Configuration {
	// private ArrayList<LineOfBusiness> searchableLOBs = new
	// ArrayList<LineOfBusiness>();
	private static final String PRODUCT_PARAM = "products";
	private static final String AMENITY_PREFIX = "_";
	private SearchFormConstants localizedTextStrings = (SearchFormConstants) GWT
			.create(SearchFormConstants.class);
	final private LineOfBusinessConfiguration lobConfig;

	public SearchFormConfiguration(Map<String, List<String>> parameters)
			throws WidgetNameException {

		super(parameters);
		lobConfig = new LineOfBusinessConfiguration(localizedTextStrings);
		/*
		 * these sizes exist for search form only and thus arent handled in the
		 * Configuration base class
		 */
		if (getSizeString().equals("180x150")) {
			setWidth(180);
			setHeight(150);
		} else if (getSizeString().equals("300x250")) {
			setWidth(300);
			setHeight(250);
		} else if (getSizeString().equals("250x250")) {
			setWidth(250);
			setHeight(250);
		} else if (getSizeString().equals("120x600")) {
			setWidth(120);
			setHeight(600);
		} else if (getSizeString().equals("160x600")) {
			setWidth(160);
			setHeight(600);
		} else if (getSizeString().equals("300x600")) {
			setWidth(300);
			setHeight(600);
		} else if (getSizeString().equals("468x60")) {
			setWidth(468);
			setHeight(60);
		} else if (getSizeString().equals("728x90")) {
			setWidth(728);
			setHeight(90);
		} else if (getSizeString().equals("450x165")) {
			setWidth(450);
			setHeight(165);
		} else if (getSizeString().equals("130x90")) {
			setWidth(130);
			setHeight(90);
		}

		if (Window.Location.getParameter("defaultsearch") != null) {
			lobConfig.setDefaultHotelSearch(Window.Location
					.getParameter("defaultsearch"));
		}

		lobConfig.setPOS(Configuration.getPOS());
		lobConfig.setNetworkTracking(Configuration.getNetworkTracking());
		lobConfig.setOpenLinksInNewWindow(getOpenLinksInNewWindow());

		String productsString = Window.Location.getParameter(PRODUCT_PARAM);
		if (productsString != null) {

			String[] a = productsString.split(",");
			for (int i = 0; i < a.length; i++) {
				if (LOBEnum.get(AMENITY_PREFIX + a[i].toLowerCase()) != null) {
					PointOfSale myPOS = Configuration.getPOS();
					if (myPOS.getAllowedLinesOfBusiness().contains(
							LOBEnum.get(AMENITY_PREFIX + a[i].toLowerCase()))) {
						//LOBEnum theLOB = ;
						//theLOB.setLineOfBusinessPanel();
						lobConfig.addLob(LOBEnum.get(AMENITY_PREFIX
								+ a[i].toLowerCase()));
					}
				}
			}

		}
		// These are the 'Let Expedia' decide values for LOBs when the user
		// doesnt care
		if (productsString == null
				|| lobConfig.getLinesOfBusiness().size() <= 0) {
			if (Configuration.getPOS().equals(PointOfSale.MX)
					|| Configuration.getPOS().equals(PointOfSale.SG)
					|| Configuration.getPOS().equals(PointOfSale.JP)) {
				lobConfig.addLob(LOBEnum.Hotel);
			} else if (Configuration.getPOS().equals(PointOfSale.ES)) {
				lobConfig.addLob(LOBEnum.Hotel);
				lobConfig.addLob(LOBEnum.FlightHotel);
				lobConfig.addLob(LOBEnum.Flight);
				lobConfig.addLob(LOBEnum.Car);
			} else {
				lobConfig.addLob(LOBEnum.Hotel);
				lobConfig.addLob(LOBEnum.FlightHotel);
				lobConfig.addLob(LOBEnum.Flight);
			}
		}

	}

	public ArrayList<LOBEnum> getLinesOfBusiness() {
		return lobConfig.getLinesOfBusiness();
	}


	@Override
	public void setWidgetName() {
		widgetName = "searchform";
	}

	public SearchFormConstants getSearchFormConstants() {
		return localizedTextStrings;
	}

	public LineOfBusinessConfiguration getLineOfBusinessConfiguration() {
		return lobConfig;
	}

	public String getDefaultSearch() {
		return LineOfBusinessConfiguration.getDefaultSearch();
	}

}

