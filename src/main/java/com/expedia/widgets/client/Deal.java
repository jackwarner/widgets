package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.expedia.widgets.client.dynamicad.LineOfBusiness;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;


public class Deal extends Composite {

	protected ArrayList<LineOfBusiness> lobs;
	protected String name;
	private GlobalConstants constants = GWT.create(GlobalConstants.class);
	private final boolean isHottestDeal;
	protected Label moreOffersLabel = new Label(constants.moreOffers());
	final private DealsWidgetConfiguration config;
	private Choreographer c;
	// TODO: make this private and access it from sub-classes only through
	// getters
	protected ArrayList<Offer> offers = new ArrayList<Offer>();
	// TODO: make this private and access it from sub-classes only through
	// getters
	protected AbsolutePanel dealPanel = new AbsolutePanel();
	@Inject
	public Deal(ArrayList<LineOfBusiness> lobs, boolean isHottestDeal,
			DealsWidgetConfiguration config) {

		this.lobs = lobs;
		this.isHottestDeal = isHottestDeal;
		this.config = config;
		final boolean newWindow = config.getOpenLinksInNewWindow();
	//	moreOffersLabel.addStyleName(SkinConstants.CLICKABLE);
		moreOffersLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String offers = getMoreOffersTracking();
				GoogleAnalytics.trackMoreOffers(offers);
				Utility.OpenLink(offers, newWindow);
			}
		});

	}

	public String getMoreOffersTracking() {
		if (!isHottestDeal) {
			String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
					+ Configuration.getNetworkTracking().replace("?", "&")
					+ "&finalurl=";
			String begining = "http%3A%2F%2Fwww.expedia.com%2Fpubspec%2Fscripts%2Feap.asp%3FGOTO%3DHOTSEARCH%26CityName%3D";
			String second = "%26InDate%3Dmm%2Fdd%2Fyyyy%26OutDate%3Dmm%2Fdd%2Fyyyy%26NumRooms%3D1%26NumAdult%3D1%26NumChild%3D0";

			if (getDealName() == null) {
				System.err.println("Deal should never be null");
			}
			return trackingRedirect + begining + getDealName() + second;
		} else {
			String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
					+ Configuration.getNetworkTracking().replace("?", "&")
					+ "&finalurl=";
			trackingRedirect = trackingRedirect
					+ Utility.escapeURL(ExpediaBusinessConstants.HOTTEST_DEALS);
			return trackingRedirect;
		}
	}

	protected void setDealName(String name) {
		this.name = name;
	}

	// what is displayed on the top of the deal, i.e. "Hottest Deal", "Chicago",
	// etc.
	public String getDealName() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	protected ArrayList<Offer> getOffers() {
		return offers;
	}

	public void animateDeal() {
		if (Configuration.isAnimated()) {
			c = new Choreographer(offers, config);
			c.beginDancing(3);
		}
	}

	public void stopAnimation() {
		if (Configuration.isAnimated() && c != null) {
			c.endDancing();
		}
	}

	public void runLoadAnimation() {
		Iterator<Offer> iterOffers = offers.iterator();
		while (iterOffers.hasNext()) {
			iterOffers.next().doLoadAnimation();
		}
	}

	protected AbsolutePanel getDealPanel() {
		return dealPanel;
	}

}
