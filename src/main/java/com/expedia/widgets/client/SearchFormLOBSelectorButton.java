package com.expedia.widgets.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.inject.Inject;


abstract public class SearchFormLOBSelectorButton extends
		LineOfBusinessSelector {
	protected ArrowMarkerSearchForm right;
	protected ArrowMarkerSearchForm left;
	protected ArrayList<LOBEnum> lobs;
	protected AbsolutePanel panel;

	protected Panel topPanel;
	protected AbsolutePanel imagePanel;
	protected int currentIndex = 0;
	private LineOfBusinessConfiguration config;

	@Inject
	public SearchFormLOBSelectorButton(
			LineOfBusinessConfiguration config) {

		this.config = config;
		panel = new AbsolutePanel();
		lobs = config.getLinesOfBusiness();
		setRight();
		setLeft();

		topPanel = new HorizontalPanel();

		left.getImage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setSelection(left.getEnum());
				goToLOBAtEnum(left.getEnum());
			}

		});

		topPanel.add(left);
		//topPanel.add(skin.getSelectorButtonMiddle());

		right.getImage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setSelection(right.getEnum());
				goToLOBAtEnum(right.getEnum());
			}

		});

		topPanel.add(right);
		panel.add(topPanel);

		imagePanel = addImages();
		panel.add(imagePanel, getImageLeft(), getImageTop());
		updateNavigationMarker(0);

		initWidget(panel);
	}

	private AbsolutePanel addImages() {
		imagePanel = new AbsolutePanel();
		imagePanel.setPixelSize(getImageWidth(), getImageHeight());
		for (int i = 0; i < lobs.size(); i++) {
			try {
				imagePanel.add(getLOBIcon(lobs.get(i)), 0, 0);
				if (i != 0) {
					imagePanel.getWidget(i).setVisible(false);
				}
			} catch (Exception e) {
				System.err
						.println("Unable to add LOB icon - have you implemented them for this size widget?  Extend skin.get"
								+ lobs.get(i).getName());
			}
		}
		return imagePanel;
	}

	
	final LineOfBusinessConfiguration getConfig() {
		return config;
	}

	private void goToLOBAtEnum(LOBEnum lobEnum) {

		int position = lobs.indexOf(lobEnum);

		imagePanel.getWidget(currentIndex).setVisible(false);
		imagePanel.getWidget(position).setVisible(true);
		currentIndex = position;

		updateNavigationMarker(position);
	}

	private void updateNavigationMarker(int currentPosition) {
		imagePanel.getWidget(currentPosition).setVisible(true);

		int rightPosition = currentPosition + 1;
		if (rightPosition >= lobs.size()) {
			rightPosition -= lobs.size();
		}
		right.setPosition(rightPosition);
		right.setEnum(lobs.get(rightPosition));
		right.setTitle(lobs.get(right.getPosition()).getName());
		int leftPosition = currentPosition - 1;

		if (leftPosition < 0) {
			leftPosition = lobs.size() - 1;
		}
		left.setPosition(leftPosition);
		left.setTitle(lobs.get(left.getPosition()).getName());
		left.setEnum(lobs.get(leftPosition));
	}

	abstract protected void setRight();

	abstract protected void setLeft();

	abstract protected int getImageTop();

	abstract protected int getImageLeft();

	abstract protected int getImageWidth();

	abstract protected int getImageHeight();

	abstract protected Image getLOBIcon(LOBEnum lob);

}