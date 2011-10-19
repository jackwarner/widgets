package com.expedia.widgets.client;

import com.google.gwt.event.shared.GwtEvent;


public class ApiCompletedEvent extends GwtEvent<ApiListener> {
	private static final Type<ApiListener> TYPE = new Type<ApiListener>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ApiListener> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ApiListener handler) {
		handler.onComplete();

	}

	public static Type<ApiListener> getType() {
		return TYPE;
	}
}
