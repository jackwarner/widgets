package com.expedia.widgets.client;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.Image;



/**
 * Animated strikeout
 * 
 * @author jack.warner
 * 
 */
public class Strikeout extends Animation {
	private int width;
	private int height;
	private Image image;
	private int pixelsToAdd = 2;

	public Strikeout(Image image, int width, int height) {
		this.image = image;
		this.image.setPixelSize(0, height);
		this.width = width;
		pixelsToAdd = width;
		this.height = height;
	}

	@Override
	protected void onUpdate(double progress) {
		width = (int) Math.round((pixelsToAdd * progress));
		image.setPixelSize(width, height);
	}

}
