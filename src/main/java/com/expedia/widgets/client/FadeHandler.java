package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;



public class FadeHandler {
	final private HandlerManager handlerManager = new HandlerManager(this);
	final protected FadeCSSResource resources = GWT
			.create(FadeCSSResource.class);
	private int i = 0;

	private static final String[] fadeStyles = { "yft00", "yft01", "yft02",
			"yft03", "yfttransparent" };
	private static final String[] appearStyles = { "yfttransparent", "yft03",
			"yft02", "yft01", "yft00" };
	Timer t;

	// private ArrayList<FadeObject> fadeObjectList = new
	// ArrayList<FadeObject>();
	/**
	 * Pass 'false' to constructor for an Appear effect
	 * 
	 * @param isFade
	 */
	public FadeHandler(final boolean isFade, final Widget w) {

		StyleInjector.inject(resources.fade().getText());

		i = 0;
		t = new Timer() {
			@Override
			public void run() {
				if (i < fadeStyles.length) {
					if (isFade) {
						w.setVisible(true);
						try {
							if (i > 0) {
								w.removeStyleName(fadeStyles[i - 1]);

							}
							w.addStyleName(fadeStyles[i]);
						} catch (Exception e) {

						}

					} else {
						try {
							if (i == 0) {
								// w.addStyleName(appearStyles[i]);
								// System.out.println("Setting element visible ");
								w.setVisible(true);
							}
							if (i > 1) {
								w.removeStyleName(appearStyles[i - 1]);
								// System.out.println("Removing style " +
								// appearStyles[i-1]);

							}
							// else {
							w.addStyleName(appearStyles[i]);
							// System.out.println("Adding style " +
							// appearStyles[i]);
						} catch (Exception e) {

						}

					}
					i++;
				} else {
					t.cancel();
					if (isFade) {
						w.setVisible(false);
						// w.addStyleName("yft00");
					} else {
						w.setVisible(true);
						// w.addStyleName("yft00");
					}
					handlerManager.fireEvent(new AnimationCompletedEvent());
				}

			}
		};

	}

	public void run() {
		t.scheduleRepeating(50);
	}

	public void addAnimationCompletedHandler(AnimationListener handler) {
		handlerManager.addHandler(AnimationCompletedEvent.getType(), handler);

	}

	static public String getOpaqueStyleName() {
		return "yft00";
	}

}

