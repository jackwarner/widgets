package com.expedia.widgets.client;

import java.util.ArrayList;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle;

public class TypeAheadOracle extends SuggestOracle {
	private static final char DESTINATION_DELIM = ',';
	private final int ALL_EXCLUDING_ADDRESS = 31;
	private final int AIRPORT = 1;
	private int type = ALL_EXCLUDING_ADDRESS;
	private ArrayList<DestinationSuggestion> l = new ArrayList<DestinationSuggestion>();

	@Override
	public boolean isDisplayStringHTML() {
		return true;
	}

	@Override
	public void requestSuggestions(final SuggestOracle.Request req,
			final SuggestOracle.Callback callback) {
		if (req.getQuery().length() > 1) {
			JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
			String locale = LocaleInfo.getCurrentLocale().getLocaleName();
			if (locale.equals("default") || locale.length() < 5) {
				locale = "en_US";
			}

			String url = "http://suggest.expedia.com/hint/es/v1/ac/" + locale
					+ "/" + req.getQuery().toLowerCase().trim()
					+ "?format=json&maxresults=" + req.getLimit() + "&type="
					+ getType();

			jsonp.requestObject(url,
					new AsyncCallback<TypeAheadDestinations>() {

						@Override
						public void onFailure(Throwable caught) {
							l.clear();
						}

						@Override
						public void onSuccess(TypeAheadDestinations result) {
							l.clear();
							JsArray<TypeAheadDestination> destinations = result
									.getDestinations();

							for (int i = 0; i < destinations.length(); i++) {
								String destination = getDestinationBySearchOption(result
										.getDestinations().get(i).getName());

								if (l.size() < req.getLimit()) {
									l.add(new DestinationSuggestion(destination));
							
								}
							}

							Response response = new Response(l);
							callback.onSuggestionsReady(req, response);
						}

					});
		}
	}

	private int getType() {
		return type;
	}

	public void setAllExcludingAddress() {
		type = ALL_EXCLUDING_ADDRESS;

	}

	public void setAirportsOnly() {
		type = AIRPORT;
	}

	private String getDestinationBySearchOption(String destination) {
		if (getType() == ALL_EXCLUDING_ADDRESS) {
			destination = destination.replace(" (and vicinity)", "");
			if ((destination.lastIndexOf(DESTINATION_DELIM) != -1)
					&& (destination.indexOf(DESTINATION_DELIM) != destination
							.lastIndexOf(DESTINATION_DELIM))) {
				destination = destination.substring(0,
						destination.lastIndexOf(DESTINATION_DELIM));
			}
		}
		if (getType() == AIRPORT) {
			try {
				destination = destination.replace(", United States", "");
				// destination =
				// destination.substring(destination.indexOf('(')+1,
				// destination.lastIndexOf(')'));
			} catch (Exception e) {

			}
		}
		return destination;
	}


}
