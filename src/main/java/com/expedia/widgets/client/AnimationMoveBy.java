package com.expedia.widgets.client;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

public class AnimationMoveBy extends Animation {
	private AbsolutePanel parent;
	private Widget toAnimation;
	int startLeftCoordinate = 0;
	int finalLeftCoordinate = 0;

	public AnimationMoveBy(AbsolutePanel parent, Widget toAnimation,
			int startingLeftPosition, int finalLeftCoordinate) {
		this.finalLeftCoordinate = finalLeftCoordinate;

		this.toAnimation = toAnimation;
		this.parent = parent;
		this.startLeftCoordinate = startingLeftPosition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.animation.client.Animation#onUpdate(double)
	 */
	@Override
	protected void onUpdate(double progress) {
		// TODO Auto-generated method stub
		int totalDistance = Math.abs(finalLeftCoordinate - startLeftCoordinate);
		parent.setWidgetPosition(toAnimation, startLeftCoordinate
				+ (int) (progress * totalDistance), 0);
	}

}
