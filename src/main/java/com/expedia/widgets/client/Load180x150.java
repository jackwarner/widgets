package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class Load180x150 extends Composite {
	final protected SearchFormLoadResources180x150 resources = GWT
			.create(SearchFormLoadResources180x150.class);
	public Load180x150() {
		initWidget(new Image(resources.canvas180x150().getSafeUri()));
	}
	
}
