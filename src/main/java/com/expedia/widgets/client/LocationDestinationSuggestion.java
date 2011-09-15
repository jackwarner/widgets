package com.expedia.widgets.client;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;


/**
 * The destination suggestion box used for hotel searches.
 * 
 * Limits by valid suggestions for Hotel destination, takes in a default
 * suggestion, and resets the suggestion onFocus if the user has not
 * 
 * @author jack.warner
 * 
 */
public class LocationDestinationSuggestion extends ExpediaSuggestion {
	boolean hadFocus = false;
	
	private HotelSearchCity data = new HotelSearchCity();
	final private boolean customSearch;

	/**
	 * Takes config info and default text for the suggestion box.
	 * 
	 * @param config
	 * @param defaultText
	 */
	public LocationDestinationSuggestion(final String defaultSearch,
			boolean hasCustomSearch) {
	
		this.customSearch = hasCustomSearch;
		oracle.setAllExcludingAddress();

		try {
			destination.setText(defaultSearch);
		} catch (Exception e) {

		}

		destination.getTextBox().addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent event) {
				System.err.println("Focused on location suggestion box");
				
				if (destination.getValue().equals(defaultSearch) && !hadFocus)
						 {
					destination.setText("");
				}
				hadFocus = true;

			}

		});
		initWidget(destination);
		// return destination;
	}

	public HotelSearchCity getData() {
		if (hadFocus) {
			System.out.println("Has indeed had focus.");
			data.set(destination.getTextBox().getValue());
		} else {
			System.out.println("Has NOT had focus.");
			if (!customSearch) {
				System.out.println("This is not a custom search");
				data.set("");
			} else {
				System.out.println("This IS a custom search");
				data.set(destination.getTextBox().getValue());
			}

		}

		return data;
	}

	public void setWidth(int width) {
		destination.setWidth(width + "px");
	}

	public void setWidthxHeight(int width, int height) {
		destination.setPixelSize(width, height);
	}

	public void setPixelSize(int width, int height) {
		setWidthxHeight(width, height);
	}

	public void setStyleName(String dropDownStyle) {
		destination.setStyleName(dropDownStyle);

	}

	public void setDestinationValue(String string) {
		destination.getTextBox().setText(string);

	}

	@Override
	public String getValue() {
		return getData().get();
	}

	public void fireFocusEvent() {
		destination.getTextBox().fireEvent(new MyFocusEvent());
		
	}
	private class MyFocusEvent extends FocusEvent{}
}
