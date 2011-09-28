package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public abstract class LOB extends Composite implements LineOfBusinessPanel {
	
	protected SearchData searchData;
	protected FocusPanel parentPanel = new FocusPanel();


	@Inject
	public LOB(
			) {

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

	protected abstract void setSearchData();
	protected void setParentPanelContent(Widget w) {
		parentPanel.clear();
		parentPanel.add(w);
	}
	protected void initWidgetParent() {
		initWidget(parentPanel);
	}
	public final SearchData getSearchData() {
		return this.searchData;
	}

	public abstract LOBEnum getEnumName();
}
