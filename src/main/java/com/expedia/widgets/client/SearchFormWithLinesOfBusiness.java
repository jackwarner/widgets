package com.expedia.widgets.client;


import com.google.gwt.user.client.ui.Composite;

public class SearchFormWithLinesOfBusiness extends Composite implements
SearchFormContract {

private LineOfBusinessConfiguration config;


protected LOBSelectionPanel lobsPanel;

public SearchFormWithLinesOfBusiness() {

}

public SearchFormWithLinesOfBusiness(
	LineOfBusinessConfiguration config) {
this.config = config;

}



public LineOfBusinessConfiguration getConfig() {
return config;
}

}