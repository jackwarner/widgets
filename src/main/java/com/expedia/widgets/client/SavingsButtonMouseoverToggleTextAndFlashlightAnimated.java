package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;

public class SavingsButtonMouseoverToggleTextAndFlashlightAnimated extends
		SavingsButtonAnimatedToggleText {
	private Image flashLight;
	AnimationMoveBy animationObject;
	@Inject
	public SavingsButtonMouseoverToggleTextAndFlashlightAnimated(
			int savingsPercentage, DealsWidgetSkin skin) {
		super(savingsPercentage, skin);
		flashLight = skin.getFlashlightImage();

		getOverlayPanel().add(flashLight);
		animationObject = new AnimationMoveBy(getOverlayPanel(), flashLight,
				(getFlashlight().getWidth() * -1), (2 * flashLight.getWidth()));
	}

	protected Image getFlashlight() {
		return flashLight;
	}

	@Override
	public void animate() {
		try {
			super.animate();
			getOverlayPanel().setWidgetPosition(getFlashlight(),
					(getFlashlight().getWidth() * -1), 0);
			animationObject.run(2000);

		} catch (Exception e) {
			System.err.println("Howdy! Unable to animated button " + e);
		}
	}
}
