package com.expedia.widgets.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;

public class Choreographer {
	private int offerToAnimate = 0;
	static Timer timer;
	int animationInterval = 2;
	private int milliSeconds = 5000;
	private ArrayList<Offer> myOffers = new ArrayList<Offer>();
	boolean ignoreAnimationRequest = false;

	private int numberOfOffers = 0;
	
	@Inject
	public Choreographer(ArrayList<Offer> offers, Configuration config) {
		myOffers.addAll(offers);
		timer = new Timer() {
			@Override
			public void run() {
				// Debug.print("Timer run at " + System.currentTimeMillis() +
				// " with ");
				if (!ignoreAnimationRequest) {
					if (offerToAnimate == numberOfOffers) {
						// setting offerToAnimate = 0 will loop through the
						// animation,
						// which is fine if that's what you want, but for this
						// case
						// we want the animaton to stop after it's finished,
						// because
						// the deal view will slide out and there is not need to
						// keep animating
						// offerToAnimate = 0;
						// offerToAnimate = 0;

						// what i am attempting to do here is guard against
						// "lazy"
						// use of this class - eventually, the class will clean
						// up after itself
						// and cancel the running timer
						timer.cancel();
						// Debug.print("Cancelling timer.");

					} else {
						try {
							if (offerToAnimate > 0) {
								myOffers.get(offerToAnimate - 1)
										.stopAnimation();
							}
						} catch (Exception e) {
							System.err
									.println("Unable to stop animation at index "
											+ (offerToAnimate - 1) + ".");

						}
						try {

							myOffers.get(offerToAnimate).doAnimation();
							offerToAnimate++;
						} catch (Exception e) {
							timer.cancel();
							System.err
									.println("Wasn't able to animate. Canceling timer.");
						}
					}
				}
			}
		};
		animationInterval = Configuration.getAnimationInterval();
	}

	public void beginDancing(int numberOfDancers) {

		if (numberOfDancers > 0) {

			milliSeconds = ((animationInterval) * 700) / numberOfDancers;
			// Debug.print("Choreographer will run sub-animations every "
			// + milliSeconds + " ms for " + numberOfDancers + " items.");
			if (milliSeconds < 2000) {
				System.err
						.println(animationInterval
								+ " second interval forces too short a time ("
								+ milliSeconds
								+ " ms) for animation.  Sub-animations will be ignored.");
				ignoreAnimationRequest = true;
			}
		}

		// Cory (the name of the Choreographer) is bound to complete his routine
		// within the time specified by the configuration constant for the
		// widget
		// Why, you ask? Because essentially Cory only gets the stage for that
		// amount of time
		// so speed up or slow down accordingly
		if (!ignoreAnimationRequest) {
			numberOfOffers = numberOfDancers;
			timer.scheduleRepeating(milliSeconds);
		}
		// Execute the timer to run every 3 seconds

	}

	public void endDancing() {
		// Debug.print("Ended animation by call to endDancing()");
		timer.cancel();
	}
}
