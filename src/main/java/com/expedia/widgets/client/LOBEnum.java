package com.expedia.widgets.client;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;


public enum LOBEnum {
	Flight("_flights", "flights") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getFlightImage();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}

	},
	Car("_cars", "cars") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getCar();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	Activities("_activities", "activities") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getActivities();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	Cruise("_cruises", "cruises") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getCruise();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	FlightCar("_flightcar", "flightcar") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getFlightCar();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	FlightHotel("_flighthotel", "flighthotel") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getFlightHotel();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	FlightHotelCar("_flighthotelcar", "flighthotelcar") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getFlightHotelCar();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	Hotel("_hotels", "hotels") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getHotelImage();
		}
		@Override
		public LOB_Hotel getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return skin.getHotelPanel();
		}
	},
	HotelCar("_hotelcar", "hotelcar") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getHotelCar();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	},
	PackageHolidays("_packageholidays", "packageholidays") {
		@Override
		public Image getIcon(LineOfBusinessSkin skin) {
			return skin.getPackageHolidays();
		}
		@Override
		public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin) {
			return null;
		}
	};

	private final String name; // used for localization files
	private final String urlParameter;
	//private final LOB lobPanel; // this is the line of Business display/search panel for the created widget size
	private SearchFormConstants localizedTextStrings = (SearchFormConstants) GWT
			.create(SearchFormConstants.class);

	/*
	 * Url parameter is what is used to construct the link to expedia
	 */
	private LOBEnum(String name, String urlParameter) {
		this.name = name;
		this.urlParameter = urlParameter;
	
	}

	/**
	 * The localized name of the Line of Business
	 * 
	 * @return
	 */
	public final String getName() {
		try {
			return localizedTextStrings.lobMap().get(name);
		} catch (Exception e) {
			return name;
		}
	}

	public final String getUrlParameter() {
		return this.urlParameter;
	}
	

	private static final Map<String, LOBEnum> lookup = new HashMap<String, LOBEnum>();

	static {
		for (LOBEnum s : EnumSet.allOf(LOBEnum.class))
			lookup.put(s.name, s);
	}

	public static LOBEnum get(String key) {
		return lookup.get(key);
	}

	abstract public Image getIcon(LineOfBusinessSkin skin);
	abstract public LOB getLineOfBusinessPanel(LineOfBusinessPanelMaker skin);
	
	
}
