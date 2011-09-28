package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;

public class SearchFormWithLinesOfBusiness extends Composite implements
		SearchFormContract {

	private LineOfBusinessConfiguration config;

	protected LOBSelectionPanel lobsPanel;

	public SearchFormWithLinesOfBusiness() {
		try {
			config = new SearchFormConfiguration(ConfigurationData.get()).getLineOfBusinessConfiguration();
		} catch (WidgetNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public LineOfBusinessConfiguration getConfig() {
		return config;
	}

}