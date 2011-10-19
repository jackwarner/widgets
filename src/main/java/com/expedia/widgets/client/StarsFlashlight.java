package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Image;


public class StarsFlashlight extends Stars {
	Image flashlight;
	AnimationMoveBy animationObject;

	public StarsFlashlight(DealsWidgetSkin skin, double rating, boolean showEmptyStars) {
		super(skin, rating, showEmptyStars);
		flashlight = skin.getFlashlightImage();
		getOverlayPanel().add(flashlight, (flashlight.getWidth() * -1), 0);
		animationObject = new AnimationMoveBy(getOverlayPanel(), flashlight,
				(-1 * flashlight.getWidth()), (2 * flashlight.getWidth()));
	}

	@Override
	public void animate() {
		if (!isAnimationPaused()) {
			getOverlayPanel().setWidgetPosition(flashlight,
					(flashlight.getWidth() * -1), 0);
			// Effect.moveBy(flashlight, 0, (2*flashlight.getWidth()));
			animationObject.run(2000);
		}
	}
}
