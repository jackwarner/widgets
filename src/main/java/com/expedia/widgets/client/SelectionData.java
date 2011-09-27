package com.expedia.widgets.client;

import com.google.gwt.i18n.client.Localizable;

public interface SelectionData extends Localizable {
	public String getValue();

	public String getName();

	public void setValue(String value);
}

