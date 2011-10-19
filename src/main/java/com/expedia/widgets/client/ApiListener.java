package com.expedia.widgets.client;

import com.google.gwt.event.shared.EventHandler;


public interface ApiListener extends EventHandler {
	void onComplete();

	void onFail();
}
