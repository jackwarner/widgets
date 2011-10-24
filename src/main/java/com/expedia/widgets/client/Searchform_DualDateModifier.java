package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.inject.Inject;


public class Searchform_DualDateModifier {
	public Searchform_DateInput current;
	public Searchform_DateInput nextDay;
	final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

	DatePicker pickerToday;
	DatePicker pickerTomorrow;
	public DateBox checkoutDate;
	public DateBox checkinDate;
	
	@Inject
	public Searchform_DualDateModifier(
			String labelTextOne, String labelTextTwo, int width, int height) {
	
		setDates();
		current = new Searchform_DateInput(labelTextOne, checkinDate,
				width, height);
		nextDay = new Searchform_DateInput(labelTextTwo, checkoutDate,
				width, height);

	}

	

	public void setDates() {
		pickerToday = new DatePicker();
		pickerTomorrow = new DatePicker();
		pickerToday.setTransientEnabledOnDates(false, new Date());

		final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		Date tomorrow = new Date();
		tomorrow.setTime(tomorrow.getTime() + MILLIS_IN_DAY);
		date.setTime(date.getTime() - MILLIS_IN_DAY);

		// pickerToday.getFirstDate().setTime(time)
		ArrayList<Date> disabledDates = new ArrayList<Date>();
		long numberOfDaysBack = 41;
		// Date twoMonthsAgo = new Date("");
		for (int i = 0; i < numberOfDaysBack; i++) {
			disabledDates.add(new Date(date.getTime() - (i * MILLIS_IN_DAY)));

		}

		pickerToday.addStyleToDates("disabled", disabledDates);
		checkinDate = new DateBox(pickerToday, new Date(),
				new DateBox.DefaultFormat(
						DateTimeFormat.getFormat(Configuration.getPOS()
								.getDateFormat())));

		pickerToday.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {

				Date today = new Date();
				if (event.getValue().before(today)) {
					// System.out.println("Cannot select a date in the past");
					// pickerToday.setVisible(true);
					checkinDate.setValue(today);
					// .setValue(today);

				} else if (event.getValue().after(checkoutDate.getValue())) {
					// Date oneDayAfterSelected
					// System.out.println("Silently set the checkout date to the next day");
					checkoutDate.setValue(new Date(event.getValue().getTime()
							+ MILLIS_IN_DAY));
				}
			}

		});

		checkoutDate = new DateBox(pickerTomorrow, tomorrow,
				new DateBox.DefaultFormat(
						DateTimeFormat.getFormat(Configuration.getPOS()
								.getDateFormat())));

		pickerTomorrow.addStyleToDates("disabled", disabledDates);
		pickerTomorrow.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date today = new Date();
				if (event.getValue().before(today)) {
					checkinDate.setValue(new Date());
					checkoutDate.setValue(new Date(today.getTime()
							+ MILLIS_IN_DAY));
				} else if (event.getValue().before(checkinDate.getValue())) {
					// System.out.println("Silently set the checkin date to the previous day");
					checkinDate.setValue(new Date(event.getValue().getTime()
							- MILLIS_IN_DAY));
				} else if ((event.getValue().getTime() - checkinDate.getValue()
						.getTime()) < MILLIS_IN_DAY) {
					checkoutDate.setValue(new Date(today.getTime()
							+ MILLIS_IN_DAY));
				}

			}

		});
	}

}