package com.expedia.widgets.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;


public class Star extends Composite {
	private static final int MS_DURATION = 500;
	final protected HandlerManager handlerManager = new HandlerManager(this);

	private Image starImage;
	private int position = 0;
	private boolean isEmpty;
	private FocusPanel focusPanel = new FocusPanel();

	public Star(Image starImage, int width, int height, int position) {
		this.starImage = starImage;
		this.starImage.setPixelSize(width, height);
	
		this.position = position;
		AbsolutePanel panel = new AbsolutePanel();
		panel.setSize((width + 5) + "px", (height + 5) + "px");

		panel.add(this.starImage);
		this.isEmpty = false;
		focusPanel.add(panel);
		
		initWidget(focusPanel);
	}

	public Star(Image starImage, int width, int height, boolean isEmpty,
			int position) {
		this.starImage = starImage;
		this.starImage.setPixelSize(width, height);
		this.position = position;
		
		AbsolutePanel panel = new AbsolutePanel();
		panel.setSize((width + 5) + "px", (height + 5) + "px");

		panel.add(this.starImage);
		this.isEmpty = isEmpty;
		focusPanel.add(panel);
	
		initWidget(focusPanel);
	}

	public void setImageUrl(String url) {

		this.starImage.setUrl(url);
	}

	protected FocusPanel getFocusPanel() {
		return focusPanel;
	}

	

	

	

	public int getAnimationDurationInMilliseconds() {
		return MS_DURATION;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public int getPosition() {
		return position;
	}

}