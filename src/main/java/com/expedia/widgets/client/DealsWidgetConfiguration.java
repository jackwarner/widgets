package com.expedia.widgets.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Window;


public class DealsWidgetConfiguration extends Configuration {
	private static DealsWidgetConfiguration instance = null;
	private static final String MAX_STAR_EXPEDIA_DECIDES = "3.5";
	private static final String MIN_STAR_EXPEDIA_DECIDES = "3.0";

	private static final String DESTINATION_PARAMETER = "destinations";
	private static final String MIN_RATING_PARAMETER = "minRating";
	private static final String MAX_RATING_PARAMETER = "minRating";
	private final DealsWidgetSkin skin = new DealsWidgetSkin120x600();
	final private String destinations;
	private Double minRating;
	private Double maxRating;

	protected DealsWidgetConfiguration(Map<String, List<String>> parameters)
			throws WidgetNameException {
		super(parameters);
		destinations = Window.Location.getParameter(DESTINATION_PARAMETER);

		String minRatingString = Window.Location
				.getParameter(MIN_RATING_PARAMETER);
		String maxRatingString = Window.Location
				.getParameter(MAX_RATING_PARAMETER);

		/*
		 * Handle min and max deal rating parameters.
		 * 
		 * For simplicity's sake, we need both min and max rating (and this
		 * should be enforced by the Widget Generator) so if min is not set, no
		 * need to check for max.
		 */
		if (minRatingString == null) {
			minRating = new Double(MIN_STAR_EXPEDIA_DECIDES);
			maxRating = new Double(MAX_STAR_EXPEDIA_DECIDES);
		} else {
			try {
				minRating = new Double(minRatingString);
				maxRating = new Double(maxRatingString);
			} catch (Exception e) { // if we have any problems with the
									// parameters, default to 2 and 4
				minRating = new Double(MIN_STAR_EXPEDIA_DECIDES);
				maxRating = new Double(MAX_STAR_EXPEDIA_DECIDES);
			}
		}

	

	}

	

	public String getUserDestinations() {
		return destinations;
	}

	public Double getMinRating() {
		return minRating;
	}

	public Double getMaxRating() {
		return maxRating;
	}


	@Override
	public void setWidgetName() {
		widgetName = "deals";
	}

	public static DealsWidgetConfiguration getInstance(
			Map<String, List<String>> configData) {
		if (instance == null) {
			try {
				instance = new DealsWidgetConfiguration(configData);
			} catch (WidgetNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;

	}



	@Override
	DealsWidgetSkin getSkin() {
		return skin;
	}

}
