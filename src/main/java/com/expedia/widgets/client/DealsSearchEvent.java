package com.expedia.widgets.client;

import com.google.gwt.event.shared.GwtEvent;



public class DealsSearchEvent extends GwtEvent<DealsSearchListener> {
	private static final Type<DealsSearchListener> TYPE = new Type<DealsSearchListener>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DealsSearchListener> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DealsSearchListener handler) {
		handler.onSearch();

	}

	public static Type<DealsSearchListener> getType() {
		return TYPE;
	}
}
