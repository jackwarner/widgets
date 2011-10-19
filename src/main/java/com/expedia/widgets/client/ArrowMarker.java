package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;



public class ArrowMarker extends Composite {

	private int position;
	private boolean isRight = false;
	private String title;
	private AbsolutePanel panel = new AbsolutePanel();

	final protected Deals120x600Resources resources = GWT
			.create(Deals120x600Resources.class);
	
	final private Image arrow;

	public ArrowMarker(int position, boolean isRight, String title) {

		this.position = position;
		this.isRight = isRight;
		panel.setPixelSize(7, 13);

		if (isRight) {
			this.arrow = new Image(resources.rightArrow());
		} else {
			this.arrow = new Image(resources.leftArrow());
		}

		panel.add(arrow, 0, 0);
		this.title = title;

		arrow.setTitle(this.title);
		arrow.addStyleName("clickable");
		initWidget(panel);
	}

	/**
	 * Gets the image used to display this marker
	 * 
	 * @return
	 */
	public Image getImage() {
		return arrow;

	}

	public boolean isRight() {
		return isRight;
	}

	/**
	 * Gets the position of this marker.
	 * 
	 * @return
	 */
	public int getPosition() {
		return this.position;
	}

	public void setPosition(int newPosition) {
		position = newPosition;
	}

	public String getDestinationName() {
		return this.title;
	}

	public void setDestinationName(String destination) {
		title = destination;
		arrow.setTitle(destination);
	}

}
