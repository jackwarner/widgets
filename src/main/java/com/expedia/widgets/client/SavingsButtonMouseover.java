package com.expedia.widgets.client;

import com.google.inject.Inject;



/**
 * Will show the button with a "pressed" visual effect on mouseover.
 * 
 * @author jack.warner
 * 
 */
public abstract class SavingsButtonMouseover extends SavingsButton {
	// private boolean toggleSavingsPercent = true; // whether or not to toggle
	// between savings percentage and book now text on mouseover
	@Inject
	public SavingsButtonMouseover(int savingsPercentage, DealsWidgetSkin skin) {
		super(savingsPercentage, skin);
	}

	@Override
	public void mouseOver() {
		getBookOut().setVisible(false);
	}

	@Override
	public void mouseOut() {
		getBookOut().setVisible(true);
	}

	@Override
	public void animate() {
		// do nothing
	}

	@Override
	public void stopAnimation() {
		// do nothing
	}
}