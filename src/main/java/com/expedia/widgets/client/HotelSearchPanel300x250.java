package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;

public class HotelSearchPanel300x250 extends LOB_Hotel {

	final private int width = 280;
	final private int height = 120;

	private Searchform_SuggestionBox destination;
	private Searchform_DualDateModifier dates;
	private Searchform_Dropdown adults;

	@Inject
	public HotelSearchPanel300x250(
			) {
		
		AbsolutePanel hotelPanel = new AbsolutePanel();

		hotelPanel.setStyleName("background");
		hotelPanel.setPixelSize(width, height);
		VerticalPanel hotelContentPanel = new VerticalPanel();

		hotelContentPanel.setPixelSize(width, height);
		Label titleLabel = new Label(getName());
		titleLabel.setStyleName("titleText");
		hotelPanel.add(titleLabel);

		HorizontalPanel places = new HorizontalPanel();
		dates = new Searchform_DualDateModifier(
				LineOfBusinessConfiguration.getSearchFormConstants().Checkin()
						+ ":", LineOfBusinessConfiguration
						.getSearchFormConstants().Checkout() + ":", 116, 21);

		adults = new Searchform_Dropdown(LineOfBusinessConfiguration
				.getSearchFormConstants().NumberOfAdults() + ":",
				AdultCounts.adults, 122, 24);
		LocationDestinationSuggestion destinationSuggestion = new LocationDestinationSuggestion(LineOfBusinessConfiguration.getSearchFormConstants().Destination(), LineOfBusinessConfiguration.isCustomSearchLocation());
		destination = new Searchform_SuggestionBox(
				LineOfBusinessConfiguration.getSearchFormConstants()
						.Destination() + ":", destinationSuggestion, new Integer("116"), new Integer("20"), 5);
		places.add(destination);
		AbsolutePanel spacer = new AbsolutePanel();
		spacer.setPixelSize(5, 5);
		places.add(spacer);

		places.add(adults);

		HorizontalPanel more = new HorizontalPanel();
		more.add(dates.current);
		AbsolutePanel spacer2 = new AbsolutePanel();
		spacer2.setPixelSize(5, 5);
		more.add(spacer2);
		more.add(dates.nextDay);

		hotelContentPanel.add(places);
		hotelContentPanel.add(more);

		AbsolutePanel buttonSpacer = new AbsolutePanel();
		buttonSpacer.setPixelSize(20, 15);
		hotelContentPanel.add(buttonSpacer);
		hotelPanel.add(hotelContentPanel);
		
		setParentPanelContent(hotelPanel);
		initWidgetParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.expedia.streetviewwidget.client.LineOfBusinessPanel#
	 * setCurrentSearchValues()
	 */
	@Override
	public void setCurrentSearchValues() {
		
		((HotelSearchData) getSearchData()).getDestinationCity().set(
				destination.getValue());
		
		((HotelSearchData) getSearchData()).getCheckinDate().set(
				dates.checkinDate.getValue());
		((HotelSearchData) getSearchData()).getCheckoutDate().set(
				dates.checkoutDate.getValue());
		((HotelSearchData) getSearchData()).getNumAdults().set(
				adults.getValue());
		((HotelSearchData) getSearchData()).getNumChildren().set("0");

	}

}
