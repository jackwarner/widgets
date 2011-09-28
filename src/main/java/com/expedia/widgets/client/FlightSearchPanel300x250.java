package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;

public class FlightSearchPanel300x250 extends LOB_Flight {

	private Searchform_SuggestionBox goingTo;
	private Searchform_SuggestionBox leavingFrom;
	private Searchform_DualDateModifier dates;
	final private int width = 280;
	final private int height = 120;

	@Inject
	public FlightSearchPanel300x250() {

		AirportDestinationSuggestion airportSuggestion = new AirportDestinationSuggestion();
		AirportDestinationSuggestion airportSuggestion2 = new AirportDestinationSuggestion();

		AbsolutePanel flightPanel = new AbsolutePanel();

		flightPanel.setStyleName("background");
		flightPanel.setPixelSize(width, height);
		VerticalPanel flightContentPanel = new VerticalPanel();

		HorizontalPanel places = new HorizontalPanel();
		leavingFrom = new Searchform_SuggestionBox(LineOfBusinessConfiguration
				.getSearchFormConstants().LeavingFrom() + ":",
				airportSuggestion, LineOfBusinessPanelConstants300x250.DD_WIDTH, LineOfBusinessPanelConstants300x250.DD_HEIGHT, LineOfBusinessPanelConstants300x250.TYPE_AHEAD_LIMIT);
		goingTo = new Searchform_SuggestionBox(LineOfBusinessConfiguration
				.getSearchFormConstants().GoingTo() + ":", airportSuggestion2, LineOfBusinessPanelConstants300x250.DD_WIDTH, LineOfBusinessPanelConstants300x250.DD_HEIGHT, LineOfBusinessPanelConstants300x250.TYPE_AHEAD_LIMIT);
		places.add(leavingFrom);
		AbsolutePanel spacer = new AbsolutePanel();
		spacer.setPixelSize(5, 5);
		places.add(spacer);
		places.add(goingTo);

		flightContentPanel.setPixelSize(width, height);
		Label titleLabel = new Label(getName());
		titleLabel.setStyleName(LineOfBusinessPanelConstants300x250.TITLE_TEXT_STYLE);
		flightPanel.add(titleLabel);

		flightContentPanel.add(places);

		dates = new Searchform_DualDateModifier(LineOfBusinessConfiguration
				.getSearchFormConstants().DepartingDate() + ":",
				LineOfBusinessConfiguration.getSearchFormConstants()
						.ReturningDate() + ":", new Integer(LineOfBusinessPanelConstants300x250.DD_WIDTH+""), new Integer(LineOfBusinessPanelConstants300x250.DD_HEIGHT+""));

		HorizontalPanel datePanel = new HorizontalPanel();
		datePanel.add(dates.current);
		AbsolutePanel dspacer = new AbsolutePanel();
		dspacer.setPixelSize(5, 5);
		datePanel.add(dspacer);
		datePanel.add(dates.nextDay);
		flightContentPanel.add(datePanel);

		AbsolutePanel buttonSpacer = new AbsolutePanel();
		buttonSpacer.setPixelSize(20, 15);
		flightContentPanel.add(buttonSpacer);
		flightPanel.add(flightContentPanel);
		initWidget(flightPanel);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.expedia.streetviewwidget.client.LineOfBusinessPanel#
	 * setCurrentSearchValues()
	 */
	@Override
	public void setCurrentSearchValues() {
		((FlightSearchData) getSearchData()).setFromAirport(leavingFrom
				.getValue());
		((FlightSearchData) getSearchData()).setToAirport(goingTo.getValue());
		((FlightSearchData) getSearchData()).setDepartDate(dates.checkinDate
				.getValue());
		((FlightSearchData) getSearchData()).setReturnDate(dates.checkoutDate
				.getValue());
		((FlightSearchData) getSearchData()).setNumberOfAdults("1");

	}

}
