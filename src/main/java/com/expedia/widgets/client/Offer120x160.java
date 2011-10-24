package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.inject.Inject;



public class Offer120x160 extends OfferWithAnimation {

	private static final int LABEL_WIDTH = 94;
	private static final int WIDTH = 102;
	private static final int HEIGHT = 160;
	private final int LEFT_PAD = 5;
	private final int TOP_PAD = 5;
	@Inject
	public Offer120x160(Hotel lob, DealsWidgetConfiguration config) {
		super(lob, config);
		AbsolutePanel offer = new AbsolutePanel();
		setSize(WIDTH, HEIGHT);
		offer.setPixelSize(WIDTH, HEIGHT);

		// dealPanel.setPixelSize(WIDTH, HEIGHT);
		offer.add(getDealImage(94, 46), LEFT_PAD, TOP_PAD);

		overlayOffer(offer, WIDTH, HEIGHT);

		getCityLabel().setPixelSize(LABEL_WIDTH, 15);
		getHotelLabel().setPixelSize(LABEL_WIDTH, 12);
		int topMarginForHotelName = 67;
		int topMarginForCityName = 52;
		if (this.lob.isHottestDeal()) {
			offer.add(getCityLabel(), (LEFT_PAD + 2), topMarginForCityName);
			offer.add(getHotelLabel(), (LEFT_PAD + 2), topMarginForHotelName);
		} else {
			offer.add(getHotelLabel(), (LEFT_PAD + 2), topMarginForCityName);
			// AbsolutePanel spacer = new AbsolutePanel();
			// spacer.setPixelSize(2, 2);
			getHotelLabel().setPixelSize(LABEL_WIDTH, 27);
			// offer.add(spacer);
		}
		offer.add(getStars(), (LEFT_PAD + 2), 81);

		HorizontalPanel prices = new HorizontalPanel();
		prices.setPixelSize(LABEL_WIDTH, 15);
		prices.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		prices.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		prices.add(getStrikePrice());
		prices.add(getOfferPrice());
		prices.add(getPerNight());

		offer.add(prices, (LEFT_PAD + 2), 98);

		setSavingsButton(new SavingsButtonSized(lob.getPercentSavings(), 92,
				35, config.getSkin()));

		offer.add(getSavingsButton(), (LEFT_PAD), 120);
		setStrikeoutAnimation(new StrikeoutAnimation(getStrikeoutImage(), 25, 7));

		offer.add(getStrikeoutAnimation(), (LEFT_PAD), 103);
		initWidget(dealPanel);
	}

	@Override
	protected void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);

	}


}
