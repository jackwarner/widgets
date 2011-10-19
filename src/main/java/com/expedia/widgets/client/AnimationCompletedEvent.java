package com.expedia.widgets.client;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author jackwarner
 * 
 */
public class AnimationCompletedEvent extends GwtEvent<AnimationListener> {
	private static final Type<AnimationListener> TYPE = new Type<AnimationListener>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AnimationListener> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AnimationListener handler) {
		handler.onComplete();

	}

	public static Type<AnimationListener> getType() {
		return TYPE;
	}

}
