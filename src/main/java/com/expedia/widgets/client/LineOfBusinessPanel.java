package com.expedia.widgets.client;

import com.google.gwt.i18n.client.Localizable;

public interface LineOfBusinessPanel extends Localizable {

	// public SearchData getSearchData();
	/**
	 * So the values are up to date when the user clicks the search button
	 */
	public void setCurrentSearchValues();
}
