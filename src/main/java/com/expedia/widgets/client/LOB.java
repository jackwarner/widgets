package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.inject.Inject;

public abstract class LOB extends Composite implements LineOfBusinessPanel {
	protected LineOfBusinessConfiguration localized;
	protected SearchData searchData;

	public LOB() {

	}
	@Inject
	public LOB(
			LineOfBusinessConfiguration lobConfig) {

		this.localized = lobConfig;
		setSearchData();

	}

	final public String getURL(LineOfBusinessConfiguration config) {
		if (getSearchData() == null) {
			System.err.println("Cannot deal with null search data");
			return null;
		} else {
			return getSearchData().getSearchUrl();
		}
	}

	public abstract String getName();

	final public LineOfBusinessConfiguration getLocalizedValues() {
		return localized;
	}

	protected abstract void setSearchData();

	public final SearchData getSearchData() {
		return this.searchData;
	}

	public abstract LOBEnum getEnumName();
}
