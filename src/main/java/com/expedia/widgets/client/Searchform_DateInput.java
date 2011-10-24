package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.inject.Inject;

public class Searchform_DateInput extends Composite {

	VerticalPanel dateInputPanel;
	DateBox dateBox;
	public Label label;

	
	@Inject
	public Searchform_DateInput(
			String labelText, DateBox dateBox, int width, int height) {
		this.dateBox = dateBox;
		dateInputPanel = new VerticalPanel();
		label = new Label(labelText);
		label.addStyleName("labelText");
		dateBox.setPixelSize(width, height);
		dateBox.setStyleName("inputField");
		dateInputPanel.add(label);
		dateInputPanel.add(dateBox);
		initWidget(dateInputPanel);

	}

}
