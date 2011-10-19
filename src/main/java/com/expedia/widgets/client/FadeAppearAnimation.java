package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Widget;


public class FadeAppearAnimation {
	static public void run(Widget fade, Widget appear) {

		fade.setVisible(true);
		appear.setVisible(false);

		FadeHandler fadeHandlerSavings = new FadeHandler(true, fade);
		final FadeHandler appearHandlerBookNow = new FadeHandler(false, appear);

		fadeHandlerSavings.run();
		fadeHandlerSavings
				.addAnimationCompletedHandler(new AnimationListener() {
					@Override
					public void onComplete() {
						// appear.setVisible(true);
						appearHandlerBookNow.run();

					}

				});
	}

}