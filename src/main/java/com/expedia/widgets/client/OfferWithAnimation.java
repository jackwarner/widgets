package com.expedia.widgets.client;

import com.google.inject.Inject;


/**
 * Technically, this should probably be renamed to OfferWithAnimation and Mous
 * 
 * @author jack.warner
 * 
 */
abstract public class OfferWithAnimation extends OfferWithMouseover {
	@Inject
	public OfferWithAnimation(Hotel lob, DealsWidgetConfiguration config) {
		super(lob, config);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAnimation() {
		getStars().animate();
		getSavingsButton().animate();
	}

	@Override
	public void stopAnimation() {
		getSavingsButton().stopAnimation();
	}

	@Override
	public void doLoadAnimation() {
		try {
			getStrikeoutAnimation().runAnimation();
		} catch (Exception e) {

		}
	}

}