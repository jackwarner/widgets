package com.expedia.widgets.client;

import com.google.gwt.event.shared.GwtEvent;

public class SearchEvent extends GwtEvent<SearchListener> {
	private static final Type<SearchListener> TYPE = new Type<SearchListener>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SearchListener> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchListener handler) {
		handler.onMiniSearch();

	}

	public static Type<SearchListener> getType() {
		return TYPE;
	}
}