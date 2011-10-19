package com.expedia.widgets.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;


public class SearchFormSimple extends SearchForm {

	public SearchFormSimple(
			SearchFormValues formValues, int width) {
		super(formValues);
		cityList.setWidth(width + "px");
		cityList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				Destination searchCity = new Destination("", "", true);

				searchCity = destinations.get(cityList.getSelectedIndex());

				searchFormValues.set(searchCity);
				GoogleAnalytics.trackChangeCity(searchCity.getName());
				handlerManager.fireEvent(new SearchEvent());
			}

		});
		searchPanel.add(cityList);
	}

}
