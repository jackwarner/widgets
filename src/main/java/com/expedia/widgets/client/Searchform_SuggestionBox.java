package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Searchform_SuggestionBox extends Composite {

	VerticalPanel suggestionPanel;
	Label label;
	ExpediaSuggestion suggestionBox;

	/**
	 * This version used the width and height defined in the layout.
	 * 
	 * @param layout
	 * @param labelText
	 * @param suggestBox
	 */
	public Searchform_SuggestionBox(
			String labelText, ExpediaSuggestion suggestBox) {
		this(labelText, suggestBox, 100,
				10);
	}

	public Searchform_SuggestionBox(
			String labelText, ExpediaSuggestion suggestBox, Integer width,
			Integer height) {
		suggestionPanel = new VerticalPanel();
		label = new Label(labelText);
		//label.setStyleName(layout.getSkin().getLabelStyle());
		suggestionBox = suggestBox;

		suggestionBox.setPixelSize(width.intValue(), height.intValue());

	//	suggestionBox.setStyleName(layout.getSkin().getInputStyle());
	//	suggestionBox.setLimit(layout.getSuggestionBoxLimit());
		suggestionPanel.add(label);
		suggestionPanel.add(suggestionBox);
		initWidget(suggestionPanel);
	}

	public String getValue() {
		return suggestionBox.getValue();
	}
}