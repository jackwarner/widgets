package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.inject.Inject;


public class Searchform_SuggestionBox extends Composite {

	private VerticalPanel suggestionPanel;
	private Label label;
	private ExpediaSuggestion suggestionBox;

	/**
	 * This version used the width and height defined in the layout.
	 * 
	 * @param layout
	 * @param labelText
	 * @param suggestBox
	 */
	@Inject
	public Searchform_SuggestionBox(
			String labelText, ExpediaSuggestion suggestBox, int numberOfResultsToReturn) {
		this(labelText, suggestBox, 100,
				10, numberOfResultsToReturn);
	}
	@Inject
	public Searchform_SuggestionBox(
			String labelText, ExpediaSuggestion suggestBox, Integer width,
			Integer height, int numberOfResultsToReturn) {
		suggestionPanel = new VerticalPanel();
		label = new Label(labelText);
		label.setStyleName("labelText");
		suggestionBox = suggestBox;

		suggestionBox.setPixelSize(width.intValue(), height.intValue());

		suggestionBox.setStyleName("inputField");
		suggestionBox.setLimit(numberOfResultsToReturn);
		suggestionPanel.add(label);
		suggestionPanel.add(suggestionBox);
		initWidget(suggestionPanel);
	}

	public String getValue() {
		return suggestionBox.getValue();
	}
}