package com.expedia.widgets.client;

import com.google.inject.Inject;



public class SavingsButtonAnimatedToggleText extends SavingsButtonMouseover {
	boolean animationInProgress = false;
	boolean isMouseOver = false;

	// private boolean detectHasStopped = true;
	@Inject
	public SavingsButtonAnimatedToggleText(int savingsPercentage,
			DealsWidgetSkin skin) {
		super(savingsPercentage, skin);

	}

	@Override
	public void mouseOver() {
		super.mouseOver();
		isMouseOver = true;
		if (!animationInProgress) {
			getSavings().setVisible(false);
			getBookNow().addStyleName(FadeHandler.getOpaqueStyleName());
			getBookNow().setVisible(true);
		}
	}

	@Override
	public void mouseOut() {
		super.mouseOut();
		isMouseOver = false;
		if (!animationInProgress) {
			getBookNow().removeStyleName(FadeHandler.getOpaqueStyleName());
			getSavings().setVisible(true);
			getBookNow().setVisible(false);
		}

	}

	@Override
	public void animate() {
		if (!isMouseOver) {
			FadeAppearAnimation.run(getSavings(), getBookNow());
			animationInProgress = true;
		}
	}

	@Override
	public void stopAnimation() {
		if (!isMouseOver) {
			// System.err.println("Stopping animation " +
			// System.currentTimeMillis());
			FadeAppearAnimation.run(getBookNow(), getSavings());
			animationInProgress = false;
		}
	}
}
