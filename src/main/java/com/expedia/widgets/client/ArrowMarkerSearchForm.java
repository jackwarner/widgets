package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

abstract public class ArrowMarkerSearchForm extends Composite {

	private int position;
	private boolean isRight = false;
	private String title;
	private LOBEnum lobEnum;
	private AbsolutePanel panel = new AbsolutePanel();

	final private Image arrow;

	public ArrowMarkerSearchForm(int position, boolean isRight, String title,
			boolean hasArrow, LOBEnum lob, Image selectorButtonRight, Image selectorButtonRightNoArrow, Image selectorButtonLeft, Image selectorButtonLeftNoArrow) {
		this.lobEnum = lob;
		this.position = position;
		this.isRight = isRight;

		if (isRight) {
			if (hasArrow) {
				this.arrow = selectorButtonRight;
			} else {
				this.arrow = selectorButtonRightNoArrow;
			}
		} else {
			if (hasArrow) {
				this.arrow = selectorButtonLeft;
			} else {
				this.arrow = selectorButtonLeftNoArrow;
			}
		}

		panel.add(arrow, 0, 0);
		this.title = title;

		arrow.setTitle(this.title);
		if (hasArrow) {
			arrow.addStyleName("clickable");
		}
		initWidget(panel);
	}

	protected void setSize(int width, int height) {
		panel.setPixelSize(width, height);
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

	@Override
	public String getTitle() {
		return this.title;
	}

	public void setTime(String newTitle) {
		title = newTitle;
		arrow.setTitle(newTitle);
	}

	public void setEnum(LOBEnum lob) {
		lobEnum = lob;
	}

	public LOBEnum getEnum() {
		return lobEnum;
	}

}
