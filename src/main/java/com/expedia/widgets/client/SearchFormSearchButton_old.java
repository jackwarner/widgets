package com.expedia.widgets.client;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SearchFormSearchButton_old extends Composite {
	private FocusPanel focusPanel = new FocusPanel();
	private AbsolutePanel panel = new AbsolutePanel();
	private Timer t;
	private AnimationMoveBy animationObject;

	public SearchFormSearchButton_old(Image theImage, final Image mouseover,
			final Image flashlight) {
		panel.setPixelSize(71, 24);
		VerticalPanel textPanel = new VerticalPanel();
		textPanel.setPixelSize(71, 24);
		textPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		textPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		theImage.addStyleName("searchButton");
		panel.add(theImage, 0, 0);
		panel.add(mouseover, 0, 0);
		mouseover.setVisible(false);
		focusPanel.add(panel);
		Label text = new Label("Search");
		text.addStyleName("searchButton");
		textPanel.add(text);
		panel.add(textPanel, 0, 0);
		panel.add(flashlight, (flashlight.getWidth() * -1), 0);
		focusPanel.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				mouseover.setVisible(true);
			}

		});

		focusPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				mouseover.setVisible(false);
			}

		});

		animationObject = new AnimationMoveBy(panel, flashlight,
				(flashlight.getWidth() * -1), (flashlight.getWidth() * 2));
		t = new Timer() {
			@Override
			public void run() {
				try {
					panel.setWidgetPosition(flashlight,
							(flashlight.getWidth() * -1), 0);
					animationObject.run(2000);

				} catch (Exception e) {
					System.err.println("Unable to animated button");
				}
			}
		};
		t.scheduleRepeating(5000);

		initWidget(focusPanel);

	}

}