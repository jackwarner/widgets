package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;



public abstract class Offer extends Composite implements ClickHandler {

	private final boolean openInNewWindow;
	protected FocusPanel dealPanel = new FocusPanel();
	protected final Hotel lob;
	private int offerWidth = 150;
	private int offerHeight = 130;

	private Label cityLabel = new Label();
	private Label hotelLabel = new Label();
	private Label strikePrice = new Label();
	private Label savingsLabel = new Label();
	private Label offerPrice = new Label();
	private Label perNight = new Label();
	private SavingsButton button;
	private StrikeoutAnimation strikeout;
	private Stars stars;
	DealsWidgetConfiguration config;

	protected NumberFormat formatter = NumberFormat.getFormat("###");

	public Offer(final Hotel lob, DealsWidgetConfiguration config) {

		this.lob = lob;
		this.openInNewWindow = config.getOpenLinksInNewWindow();
		this.stars = new StarsFlashlight(config.getSkin(), this.lob.getStarRating().doubleValue(), true);
		// this.dealImage = this.lob.getImage(122,46);
		this.config = config;
		try {
			cityLabel.setText(lob.getCityName());

			cityLabel.addStyleName(config.getSkin().getCityLabelStyleName());
			hotelLabel.setText(lob.getName());
			if (this.lob.isHottestDeal()) {
				hotelLabel.addStyleName(config.getSkin().getHotelStyleName());
			} else {
				hotelLabel.addStyleName(config.getSkin()
						.getHotelStyleNameSmall());
			}

			strikePrice.setText("$" + formatter.format(this.lob.getPrice()));
			strikePrice.addStyleName(config.getSkin().getStrikePriceStyle());
			offerPrice.setText("$" + formatter.format(this.lob.getSalePrice()));
			offerPrice.addStyleName(config.getSkin().getOfferPriceStyle());
			perNight.setText(" / night");
			perNight.addStyleName(config.getSkin().getPerNightLabel());

			dealPanel.addStyleName(config.getSkin().getOfferStyleName());
			dealPanel.addClickHandler(this);

			savingsLabel.setText(lob.getLocalizedPercentSavings());
			savingsLabel
					.addStyleName(config.getSkin().getSavingsPercentStyle());
		
			/**
			 * If the user's mouse hovered over an offer, record it.
			 * 
			 * It suggests we got their attention, and then we can see how often
			 * they actually click a deal.
			 */
			dealPanel.addMouseOverHandler(new MouseOverHandler() {

				@Override
				public void onMouseOver(MouseOverEvent event) {
					GoogleAnalytics.trackMouseOverOffer(lob.getTracking());
				}

			});
		} catch (Exception e) {
			System.err.println("Problem constructing Deal Offer.");
		}

	}

	final protected void setStrikeoutAnimation(StrikeoutAnimation a) {
		this.strikeout = a;
	}

	public StrikeoutAnimation getStrikeoutAnimation() {
		return this.strikeout;
	}

	final protected void setSavingsButton(SavingsButton b) {
		this.button = b;
	}

	protected Image getStrikeoutImage() {
		return config.getSkin().getStrikeoutImage();
	}

	public SavingsButton getSavingsButton() {

		return this.button;
	}

	// public abstract void initSavingsButton(SavingsButton b);

	@Override
	public final void onClick(ClickEvent event) {

		GoogleAnalytics.trackOfferClick(lob.getTracking());
		Utility.OpenLink(lob.getTracking(), openInNewWindow);

	}

	public Label getCityLabel() {
		return cityLabel;
	}

	public final Stars getStars() {
		return stars;
	}

	public Label getHotelLabel() {
		return hotelLabel;
	}

	public Label getStrikePrice() {
		return strikePrice;
	}

	public Label getOfferPrice() {
		return offerPrice;
	}

	public Label getPerNight() {
		return perNight;
	}

	public Label getSavings() {
		return savingsLabel;
	}

	/**
	 * 
	 * @param width
	 * @param height
	 */
	protected abstract void setSize(int width, int height);

	final public int getOfferHeight() {

		return this.offerHeight;

	}

	final public int getOfferWidth() {

		return this.offerWidth;

	}

	final protected void setWidth(int width) {
		this.offerWidth = width;
		this.dealPanel.setWidth(width + "px");
	}

	final protected void setHeight(int width) {
		this.offerHeight = width;
		this.dealPanel.setHeight(width + "px");
	}

	public final String getLineOfBusinessName() {
		return this.lob.getName();
	}

	protected HotelImage getDealImage(int width, int height) {
		return this.lob.getImage(width, height);
	}

	/**
	 * Provided so @DealViewParent can initiate animations on offers.
	 * 
	 * The default is to not support animation, but individual offers can
	 * implement it if they wish to.
	 */
	public void doAnimation() {
		// default is to do nothing - the Offer subclass is responsible for
		// providing animation logic if required
	}

	public void stopAnimation() {
		// default is to do nothing - the Offer subclass is responsible for
		// providing animation logic if required
	}

	public void doLoadAnimation() {
		// TODO Auto-generated method stub

	}
}
