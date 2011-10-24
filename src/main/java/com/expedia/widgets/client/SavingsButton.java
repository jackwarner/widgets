package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;



abstract public class SavingsButton extends Composite {

	private Image bookOut;
	private Image bookOver;
	private Label savings;
	private Label bookNow;
	private FocusPanel focusPanel = new FocusPanel();
	private static final double FADE_DURATION = .3;
	private WidgetMessages messages = GWT.create(WidgetMessages.class);
	AbsolutePanel bigPanel = new AbsolutePanel();
	private AbsolutePanel panel = new AbsolutePanel();
	AbsolutePanel overlayPanel = new AbsolutePanel();
	@Inject
	public SavingsButton(final int savingsPercentage, final DealsWidgetSkin skin) {
		
				bookOut = skin.getBookNowImage();
				bookOver = skin.getBookNowImageHover();
				savings = new Label(messages.savings(savingsPercentage));
				bookNow = new Label("Book Now");
				savings.addStyleName(skin.getBookButtonStyleName());
				bookNow.addStyleName(skin.getBookButtonStyleName());
				bookNow.setVisible(false);
				bigPanel.add(panel, 0, 0);
				bigPanel.add(overlayPanel, 0, 0);
				focusPanel.add(bigPanel);
				initWidget(focusPanel);
		
	}

	public void setSize(int WIDTH, int HEIGHT) {
		panel.setPixelSize(WIDTH, HEIGHT);
		overlayPanel.setPixelSize(WIDTH, HEIGHT);
		bigPanel.setPixelSize(WIDTH, HEIGHT);
		focusPanel.setPixelSize(WIDTH, HEIGHT);
	}

	public AbsolutePanel getPanel() {
		return panel;
	}

	public AbsolutePanel getOverlayPanel() {
		panel.add(overlayPanel, 0, 0);
		return overlayPanel;
	}

	public Image getBookOut() {
		return bookOut;
	}

	public Image getBookOver() {
		return bookOver;
	}

	public Label getSavings() {
		return savings;
	}

	public Label getBookNow() {
		return bookNow;
	}

	public WidgetMessages getMessages() {
		return messages;
	}

	public double getFadeDuration() {
		return FADE_DURATION;
	}

	abstract public void mouseOver();

	abstract public void mouseOut();

	abstract public void animate();

	abstract public void stopAnimation();
}
