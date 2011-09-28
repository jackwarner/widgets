package com.expedia.widgets.client;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;

public class AirportDestinationSuggestion  extends ExpediaSuggestion {


	private HotelSearchCity data = new HotelSearchCity();

	/**
	 * Takes config info and default text for the suggestion box.
	 * 
	 * @param config
	 * @param defaultText
	 */
	public AirportDestinationSuggestion() {
		// this.data = city;
		oracle.setAirportsOnly();

		if (LineOfBusinessConfiguration.getDefaultSearch().length() > 0) {
			destination.setText(LineOfBusinessConfiguration.getDefaultSearch());
		} else {
			try {
				destination.setText(LineOfBusinessConfiguration
						.getSearchFormConstants().getDefaultFlightText());
			} catch (Exception e) {

			}
		}
		destination.getTextBox().addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent event) {
				if (destination.getValue().equals(
						LineOfBusinessConfiguration.getSearchFormConstants()
								.getDefaultFlightText())
						|| destination.getValue().equals(
								LineOfBusinessConfiguration.getDefaultSearch())) {
					destination.setText("");
				}

			}

		});
		initWidget(destination);
	}

	public HotelSearchCity getData() {
		data.set(destination.getTextBox().getValue());
		return data;
	}

	public void setWidth(int width) {
		destination.setWidth(width + "px");
	}

	public void setWidthxHeight(int width, int height) {
		destination.setPixelSize(width, height);
	}

	@Override
	public String getValue() {
		return getData().get();
	}
}

