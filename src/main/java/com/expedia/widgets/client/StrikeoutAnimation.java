package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;


public class StrikeoutAnimation extends Composite {
	Strikeout animation;
	private Image image;
	private static final int MS_DURATION = 500;

	// public
	public StrikeoutAnimation(Image strikeoutImage, int width, int height) {
		AbsolutePanel panel = new AbsolutePanel();
		panel.setPixelSize(width, height);
		strikeoutImage.setPixelSize(0, height);

		this.image = strikeoutImage;
		animation = new Strikeout(this.image, width, height);
		panel.add(this.image, 0, 0);
		initWidget(panel);
	}

	public void runAnimation() {
		animation.run(MS_DURATION);
	}
}
