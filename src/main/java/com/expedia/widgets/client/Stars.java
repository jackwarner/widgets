package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;


/**
 * TODO: Merge with HotelAmenityStars
 * 
 * @author jack.warner
 * 
 */
abstract public class Stars extends Composite {

	private ArrayList<Star> stars = new ArrayList<Star>();
	private final int MAX_RATING = 5;
	// TODO: consolidate these into a single parent class, WidgetSkin
	private final WidgetSkin skin;

	private AbsolutePanel panel = new AbsolutePanel();
	private AbsolutePanel overlayPanel = new AbsolutePanel();

	private int userInteractionRating = 3;
	final double rating;
	private boolean isAnimationPaused = false;

	public Stars(WidgetSkin skin, double rating, boolean showEmptyStars) {
		this(skin, rating, showEmptyStars, true); // by default, the
															// overlay panel is
															// supported
	}

	/**
	 * Constructor for Deals Widget
	 * 
	 * 
	 * 
	 * @param skin
	 * @param rating
	 * @param isLarge
	 * @param showEmptyStars
	 * @param addOverlayPanelForAnimation
	 *            is used to support an animation on top of the stars - adding
	 *            it will prevent the mouseover event from firing
	 */
	public Stars(WidgetSkin skin, double rating, boolean showEmptyStars, boolean addOverlayPanelForAnimation) {
		this.rating = rating;
		this.skin = skin;
		panel.setPixelSize(getWidth(), getHeight());
		overlayPanel.setPixelSize(getWidth(), getHeight()); // this is used for
															// animation effects
															// that are above
															// all the stars,
															// such as a
															// flashlight
		for (int i = 0; i < this.rating; i++) {

			if ((this.rating - i) == .5) {
				if (skin.showEmptyStars()) {
					getStars().add(
							new Star(skin.getEmptyHalfStar(),
									getStarWidth(), getStarHeight(), i));
				} else {
					getStars().add(
							new Star(skin.getHalfStar(), getStarWidth(),
									getStarHeight(), i));
				}

			} else {
				getStars().add(
						new Star(skin.getFullStar(), getStarWidth(),
								getStarHeight(), i));
			}
		}
		int ratingRoundedUp = (int) Math.ceil(this.rating);
		while (skin.showEmptyStars() && (ratingRoundedUp < MAX_RATING)) {
			getStars().add(
					new Star(skin.getEmptyFullStar(), getStarWidth(),
							getStarHeight(), true, (ratingRoundedUp)));
			ratingRoundedUp++;
		}

		Iterator<Star> starsIter = getStars().iterator();
		int i = 0;
		while (starsIter.hasNext()) {
			Star star = starsIter.next();
			star.setSize(getStarWidth() + "px", getStarHeight() + "px");
			// System.out.println("Setting star to size " + getStarWidth() + "x"
			// + getStarHeight());
			panel.insert(star, (i * ((getStarWidth()) + 2)), 0, 0);// (star,i*(star.getWidth()),0);
			i++;
		}
		if (addOverlayPanelForAnimation) {
			panel.add(overlayPanel, 0, 0);
		} else {
			panel.addStyleName(skin.getClickable());
		}
		initWidget(panel);

	}

	public int getStarWidth() {
		return skin.getAnimatedStarWidth();
	}

	public int getStarHeight() {
		return skin.getAnimatedStarHeight();
	}

	public void animate() {

	}

	public final int getWidth() {
		return skin.getStarPanelWidth();
	}

	public final int getHeight() {
		return skin.getStarPanelHeight();
	}

	public ArrayList<Star> getStars() {
		return stars;
	}

	protected AbsolutePanel getOverlayPanel() {
		return overlayPanel;
	}

	public void mouseOver() {
		this.isAnimationPaused = true;
	}

	public void mouseOut() {
		this.isAnimationPaused = false;
	}

	/**
	 * Communicates to implementing classes whether or not to animate the stars
	 * based on external implementation details.
	 * 
	 * @return
	 */
	protected boolean isAnimationPaused() {
		return this.isAnimationPaused;
	}

	/**
	 * The method used to reset the animation, if applicable.
	 * 
	 * The example of an animation that is reset is Hotel Amenity, where the
	 * stars light up one by one, then when the user mouses over the animation,
	 * it goes back to the preset value.
	 * 
	 * The example of one that isn't reset is deals widget, which just a
	 * flashlight image that lights up the stars every few seconds.
	 */
	public void reset() {

	}

	/**
	 * The rating as initially set - either by data or configuration, without
	 * any user interaction.
	 * 
	 * This value cannot change once set.
	 * 
	 * @return
	 */
	public double getRating() {
		return this.rating;
	}

	/**
	 * If the user can change the star rating, this will return that rating that
	 * the user changed.
	 * 
	 * @return
	 */
	public int getUserInteractionRating() {
		return this.userInteractionRating;
	}

	protected void setUserInteractionRating(int rating) {
		this.userInteractionRating = rating;
	}

	protected WidgetSkin getSkin() {
		return skin;
	}
}