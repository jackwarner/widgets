package com.expedia.widgets.client;

import com.google.gwt.i18n.client.Messages;


public interface WidgetMessages extends Messages {

	@DefaultMessage("Save {0}%")
	String savings(int savingsPercentage);

}
