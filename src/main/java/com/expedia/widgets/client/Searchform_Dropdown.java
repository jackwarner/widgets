package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Searchform_Dropdown extends Composite {

	VerticalPanel dropdownPanel;
	public Label label;
	ListBox listBox;

	

	public Searchform_Dropdown(String labelText,
			ArrayList<SelectionData> array, int width, int height) {
		dropdownPanel = new VerticalPanel();
		label = new Label(labelText);

		listBox = new ListBox();
		listBox.setPixelSize(width, height);
		label.setStyleName("labelText");
		listBox.setStyleName("inputField");

		Iterator<SelectionData> iter = array.iterator();
		while (iter.hasNext()) {
			SelectionData data = iter.next();
			listBox.addItem(data.getName(), data.getValue());
		}

		dropdownPanel.add(label);
		dropdownPanel.add(listBox);
		initWidget(dropdownPanel);
	}

	public String getValue() {
		try {
			return listBox.getValue(listBox.getSelectedIndex());
		} catch (Exception e) {
			System.err.println("Couldnt parse input so searching for value 1");
			return "1";
		}
	}

}