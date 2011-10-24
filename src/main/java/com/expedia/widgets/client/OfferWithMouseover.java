package com.expedia.widgets.client;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;


abstract public class OfferWithMouseover extends Offer {

	private AbsolutePanel deal = new AbsolutePanel();
	// private static final double FADE_DURATION = .3;
	// private static final double APPEAR_DURATION = .1;
	private AbsolutePanel dealGray = new AbsolutePanel();
	@Inject
	public OfferWithMouseover(Hotel lob, final DealsWidgetConfiguration config) {
		super(lob, config);

		dealGray.setStyleName(config.getSkin().getOfferMouseOverStyle());
		dealGray.setVisible(false);
		deal.add(dealGray);
		dealPanel.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				dealGray.setVisible(true);
				/*
				 * The mouseover initially used scriptaculous to handle fade
				 * effects, but the size of the library negatively impacted the
				 * load time so significantly (over half the initial download
				 * size) that we removed it and used GWT Animation class
				 * instead.
				 * 
				 * Effect.appear(dealGray, new EffectOption[]{new
				 * EffectOption("afterFinish", callback), new
				 * EffectOption("duration", APPEAR_DURATION)});
				 */
				if (config.getSkin().isBookingButtonHoverable()) {
					bookNowMouseOver();
				}
				starsMouseOver();

			}

		});

		dealPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {

				/*
				 * Effect.fade(dealGray, new EffectOption[]{ new
				 * EffectOption("duration", FADE_DURATION)});
				 */
				dealGray.setVisible(false);
				bookNowMouseOut();
				starsMouseOut();
			}

		});
		dealPanel.add(deal);

	}

	protected void overlayOffer(Widget offer, int width, int height) {
		deal.add(offer, 0, 0);
		deal.setWidth(width + "px");
		deal.setHeight(height + "px");
		dealGray.setWidth(width + "px");
		dealGray.setHeight(height + "px");
	}

	/**
	 * The stars can have different behavior on mouse over.
	 * 
	 * The default behavior is to have any animation routine pause while the
	 * user is moused over the stars. This is because the current animation
	 * relies on a transparent png for a "flashlight" effect that does not work
	 * well with the blue background that is shown on mouseover.
	 * 
	 */
	protected void starsMouseOver() {
		if (getStars() != null) {
			getStars().mouseOver();
		}
	}

	protected void starsMouseOut() {
		if (getStars() != null) {
			getStars().mouseOut();
		}
	}

	protected void bookNowMouseOver() {
		if (getSavingsButton() != null) {
			getSavingsButton().mouseOver();
		}

	}

	protected void bookNowMouseOut() {
		if (getSavingsButton() != null) {
			getSavingsButton().mouseOut();
		}
	}

}
