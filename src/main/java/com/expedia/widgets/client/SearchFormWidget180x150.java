/**
 * 
 */
package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

/**
 * @author jackwarner
 * 
 */
public class SearchFormWidget180x150 extends Composite {
	private static final String TO = "To";
	private static final String FROM = "From";
	private static final String HALF_WIDTH = "65px";
	private static final String FLIGHT_WIDTH = "63px";
	private static final String HOTEL_WIDTH = "143px";
	private static final String INNER_WIDTH = "160px";
	private static final String INNER_HEIGHT = "150px";
	private String lastHotelVal = "";
	AbsolutePanel panel = new AbsolutePanel();
	private final String GROUP = "lobs";
	static private SearchFormConfiguration config;
	
	final protected SearchFormResources180x150 resources = GWT
			.create(SearchFormResources180x150.class);

	DatePicker pickerToday = new DatePicker();
	DatePicker pickerTomorrow = new DatePicker();
	DateBox checkoutDate;
	DateBox checkinDate;
	VerticalPanel hotelPanel = new VerticalPanel();
	TypeAheadOracle oracle = new TypeAheadOracle();
	TypeAheadOracle oracle2 = new TypeAheadOracle();
	LocationDestinationSuggestion destination; 
	SuggestBox airportFrom = new SuggestBox(oracle2);
	RadioButton hotels = new RadioButton(GROUP);
	RadioButton flights = new RadioButton(GROUP);

	public SearchFormWidget180x150() {
		try {
			config = new SearchFormConfiguration(
					Window.Location.getParameterMap());
			oracle.setAllExcludingAddress();
			oracle2.setAllExcludingAddress();
			destination = new LocationDestinationSuggestion(LineOfBusinessConfiguration.getSearchFormConstants().Destination(), LineOfBusinessConfiguration.isCustomSearchLocation());
			 
			panel.setPixelSize(config.getWidth(), config.getHeight());
			panel.add(new Image(resources.canvas180x150()));
			panel.add(getLineOfBusinessSelection(), 14, 36);

			destination.setWidth(HOTEL_WIDTH);
			
			destination.setDestinationValue(config.getDefaultSearch());
		
			StyleInjector.inject(resources.myCss().getText());

			destination.setLimit(3);
			airportFrom.setLimit(3);
			airportFrom.setVisible(false);
			airportFrom.setWidth(FLIGHT_WIDTH);
			airportFrom.setText(TO);
	
			airportFrom.getTextBox().addFocusHandler(new FocusHandler() {

				@Override
				public void onFocus(FocusEvent event) {
					if (airportFrom.getValue().equals(TO)) {
						airportFrom.setText("");
					}
				}

			});

			hotelPanel.add(destination);

			hotelPanel.setSize(INNER_WIDTH, INNER_HEIGHT);

			pickerToday.setTransientEnabledOnDates(false, new Date());

			final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
			Date date = new Date();
			Date tomorrow = new Date();
			tomorrow.setTime(tomorrow.getTime() + MILLIS_IN_DAY);
			date.setTime(date.getTime() - MILLIS_IN_DAY);

			Label checkin = new Label("Check-in:");
			checkin.addStyleName("labelStyle");
			// pickerToday.getFirstDate().setTime(time)
			ArrayList<Date> disabledDates = new ArrayList<Date>();
			long numberOfDaysBack = 41;
			// Date twoMonthsAgo = new Date("");
			for (int i = 0; i < numberOfDaysBack; i++) {
				disabledDates
						.add(new Date(date.getTime() - (i * MILLIS_IN_DAY)));

			}

			pickerToday.addStyleToDates("disabled", disabledDates);
			checkinDate = new DateBox(pickerToday, new Date(),
					new DateBox.DefaultFormat(
							DateTimeFormat.getFormat("M/d/yy")));

			pickerToday.addValueChangeHandler(new ValueChangeHandler<Date>() {

				@Override
				public void onValueChange(final ValueChangeEvent<Date> event) {
					GWT.runAsync(new RunAsyncCallback() {

						@Override
						public void onFailure(Throwable reason) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess() {
							// TODO Auto-generated method stub
							Date today = new Date();
							if (event.getValue().before(today)) {
								System.out
										.println("Cannot select a date in the past");
								// pickerToday.setVisible(true);
								checkinDate.setValue(today);
								// .setValue(today);

							} else if (event.getValue().after(
									checkoutDate.getValue())) {
								// Date oneDayAfterSelected
								System.out
										.println("Silently set the checkout date to the next day");
								checkoutDate.setValue(new Date(event.getValue()
										.getTime() + MILLIS_IN_DAY));
							}
						}

					});

				}

			});

			HorizontalPanel datePanel = new HorizontalPanel();
			datePanel.setWidth(INNER_WIDTH);

			VerticalPanel dates = new VerticalPanel();
			checkinDate.setWidth(HALF_WIDTH);
			datePanel.add(dates);

			dates.add(checkin);
			dates.add(checkinDate);
			datePanel.add(dates);

			Label checkout = new Label("Check-out:");
			checkout.addStyleName("labelStyle");

			checkoutDate = new DateBox(pickerTomorrow, tomorrow,
					new DateBox.DefaultFormat(
							DateTimeFormat.getFormat("M/d/yy")));
			checkoutDate.setWidth(HALF_WIDTH);
			pickerTomorrow.addStyleToDates("disabled", disabledDates);
			pickerTomorrow
					.addValueChangeHandler(new ValueChangeHandler<Date>() {

						@Override
						public void onValueChange(
								final ValueChangeEvent<Date> event) {

							GWT.runAsync(new RunAsyncCallback() {

								@Override
								public void onFailure(Throwable reason) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess() {
									// TODO Auto-generated method stub
									Date today = new Date();
									if (event.getValue().before(today)) {
										checkinDate.setValue(new Date());
										checkoutDate.setValue(new Date(today
												.getTime() + MILLIS_IN_DAY));
									} else if (event.getValue().before(
											checkinDate.getValue())) {
										System.out
												.println("Silently set the checkin date to the previous day");
										checkinDate.setValue(new Date(event
												.getValue().getTime()
												- MILLIS_IN_DAY));
									} else if ((event.getValue().getTime() - checkinDate
											.getValue().getTime()) < MILLIS_IN_DAY) {
										checkoutDate.setValue(new Date(today
												.getTime() + MILLIS_IN_DAY));
									}
								}

							});

						}

					});

			VerticalPanel dates2 = new VerticalPanel();
			dates2.add(checkout);
			dates2.add(checkoutDate);

			datePanel.add(dates2);
			Image button = new Image(resources.search());
			Image buttonOver = new Image(resources.searchMouseOver());
			Image flashlight = new Image(resources.flashlight());

			panel.add(hotelPanel, 14, 55);
			panel.add(datePanel, 14, 80);
			FocusPanel fPanel = new FocusPanel();
			SearchFormSearchButton_old searchButton = new SearchFormSearchButton_old(
					button, buttonOver, flashlight);
			fPanel.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					GWT.runAsync(new RunAsyncCallback() {

						@Override
						public void onFailure(Throwable reason) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess() {
							// TODO Auto-generated method stub
							String trackingRedirect = "";
							if (flights.getValue()) {
								FlightHotelSearchData flightHotelData = new FlightHotelSearchData();
								flightHotelData.setDepartDate(checkinDate
										.getValue());
								flightHotelData.setReturnDate(checkoutDate
										.getValue());
								flightHotelData.setFromAirport(destination
										.getValue()); // THESE
														// ARE
								flightHotelData.setToCity(airportFrom
										.getValue()); // BACKWARDS!!!!

								trackingRedirect = flightHotelData
										.getSearchUrl();

							} else {
								HotelSearchData hotelData = new HotelSearchData();
								HotelSearchCity searchCity = new HotelSearchCity();
								HotelCheckInDate hotelCheckinDate = new HotelCheckInDate();
								HotelCheckOutDate hotelCheckoutDate = new HotelCheckOutDate();
								searchCity.set(destination.getValue());
								hotelCheckinDate.set(checkinDate.getValue());
								hotelCheckoutDate.set(checkoutDate.getValue());

								hotelData.setDestinationCity(searchCity);
								hotelData.setCheckinDate(hotelCheckinDate);
								hotelData.setCheckoutDate(hotelCheckoutDate);

								trackingRedirect = hotelData.getSearchUrl();
								System.err.println(trackingRedirect);
								Utility.OpenLink(trackingRedirect,
										config.getOpenLinksInNewWindow());
								// Window.Location.replace(trackingRedirect);
							}
						}

					});

				}

			});
			fPanel.add(searchButton);
			panel.add(fPanel, 52, 115);
			panel.setStyleName("summer-searchform");
			panel.add(new Image(resources.expediaLogoKayak()), 44, 6);
			panel.add(airportFrom, 93, 55);
			initWidget(panel);
		} catch (WidgetNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private HorizontalPanel getLineOfBusinessSelection() {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setWidth(INNER_WIDTH);

		hotels.setText("Hotels");
		hotels.addStyleName("labelStyle");
		hotels.setValue(true);

		flights.addStyleName("labelStyle");
		flights.setText("Flight + Hotel");

		flights.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(final ValueChangeEvent<Boolean> event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess() {
						// TODO Auto-generated method stub
						if (event.getValue()) {
							oracle.setAirportsOnly();
							destination.setWidth(FLIGHT_WIDTH);
							lastHotelVal = destination.getValue();
							destination.setDestinationValue(FROM);
							airportFrom.setVisible(true);

						} else {
							oracle.setAllExcludingAddress();
							destination.setWidth(HOTEL_WIDTH);
							destination.setDestinationValue(lastHotelVal);
						}
					}
				});

			}
		});
		hotels.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(final ValueChangeEvent<Boolean> event) {
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess() {
						// TODO Auto-generated method stub
						if (event.getValue()) {
							oracle.setAllExcludingAddress();
							destination.setWidth(HOTEL_WIDTH);
							destination.setDestinationValue(lastHotelVal);
							airportFrom.setVisible(false);

						}
					}
				});

			}

		});

		panel.add(hotels);
		panel.add(flights);
		return panel;
	}
}
