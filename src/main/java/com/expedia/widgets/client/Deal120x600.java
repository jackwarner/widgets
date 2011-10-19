package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.expedia.widgets.client.dynamicad.LineOfBusiness;


public class Deal120x600 extends Deal {

	private final int WIDTH = 130;
	private final int HEIGHT = 535;

	public Deal120x600(ArrayList<LineOfBusiness> lobs, boolean isHottestDeal,
			DealsWidgetConfiguration config) {
		super(lobs, isHottestDeal, config);

		getDealPanel().setSize(WIDTH + "px", HEIGHT + "px");

		Iterator<LineOfBusiness> lobIter = lobs.iterator();
		//int numAds = config.getLayout().getDealsPerDestination();
		int numAds = 3;
		int i = 0;

		while (lobIter.hasNext() && (i < numAds)) {
			i++;
			try {
				final LineOfBusiness lob = lobIter.next();
				getOffers().add(new Offer120x160(((Hotel) lob), config));
				setDealName(((Hotel) lob).getCity());
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		}

		Iterator<Offer> offerIter = offers.iterator();
		i = 0;
		while (offerIter.hasNext()) {
			Offer120x160 offer = (Offer120x160) offerIter.next();

			getDealPanel().add(offer, 0,
					((i * offer.getOfferHeight() + (i * 1))));
			i++;
		}

		// moreOffersLabel.setText("More Hotel Offers");
		dealPanel.add(moreOffersLabel, 180, 270);

		initWidget(dealPanel);
	}

}
