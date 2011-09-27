package com.expedia.widgets.client;

import com.google.gwt.event.shared.GwtEvent;

public class LOBChangedEvent extends GwtEvent<LOBListener> {
	private static final Type<LOBListener> TYPE = new Type<LOBListener>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LOBListener> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LOBListener handler) {
		handler.onChange();

	}

	public static Type<LOBListener> getType() {
		return TYPE;
	}
}