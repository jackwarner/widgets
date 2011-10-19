/**
 * 
 */
package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.expedia.widgets.client.dynamicad.LineOfBusiness;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author jackwarner
 *
 */
public class DealsWidget120x600 extends Composite {
	final protected Deals120x600Resources resources = GWT
			.create(Deals120x600Resources.class);
	private DealsEngineApi api;
	private AbsolutePanel panel = new AbsolutePanel();
	private VerticalPanel loadingPanel = new VerticalPanel();
	private static DealsWidgetConfiguration config;
	private ArrayList<Deal> dealParents = new ArrayList<Deal>();
	private ArrayList<Widget> deals = new ArrayList<Widget>();
	private SearchFormValues searchFormUserValues = new SearchFormValues();
	private DealViewSlider dealView;
	public DealsWidget120x600() {
		try {
			config = new DealsWidgetConfiguration(
					Window.Location.getParameterMap());
			doLayoutWork();
		} catch (WidgetNameException e) {
			// TODO Auto-generated catch block
			System.err.println("problem creating deals widget");
			e.printStackTrace();
		}
		
		//WidgetLayoutSummerSkinDefault120x600 layoutSkin = new WidgetLayoutSummerSkinDefault120x600();
		//layout = new WidgetLayoutSummer120x600(
	//			config.getLayoutString(), layoutSkin);
		
		
		
	}
	private void doLayoutWork() {
		//config.setLayout(layout);
		panel.addStyleName("summer");
		panel.setPixelSize(120, 600);
		//panel.add(new Image(resources.canvas()),0,0);
		//layout.setBackground(panel);

		showLoadingPanel();

		bootUp();

		// All composites must call initWidget() in their constructors.
		initWidget(panel);
		System.out.println("Deals widget 120x600 has initialized.");
	}
	
	private void showLoadingPanel() {
		panel.clear();
		panel.add(new Image(resources.canvas()),0,0);
		
		loadingPanel.setVisible(true);
		loadingPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		loadingPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		loadingPanel.setSize("120px", "50px");
		
		if (loadingPanel.getWidgetCount() <= 0) {
			config.getSkin().setLoaderPanel(loadingPanel);
		}

		panel.add(loadingPanel, 0, 45);

	}
	
	private void bootUp() {
		api = new DealsEngineApi(new Integer("3"),
				new Integer("5"), config.getUserDestinations(),
				config.getMinRating(), config.getMaxRating(),
				Configuration.getNetworkTracking());

		api.addApiCompletedHandler(new ApiListener() {

			HashMap<String, ArrayList<LineOfBusiness>> lobs = new HashMap<String, ArrayList<LineOfBusiness>>();

			@Override
			public void onComplete() {

				lobs = api.getDealsForDisplay();
				// now that we've gotten everything we need from the
				// API, start
				// with the display black magic ;)
				deals = new ArrayList<Widget>();
				dealParents.clear();
				Deal120x600 d = null;
				Iterator<Entry<String, ArrayList<LineOfBusiness>>> dealIter = lobs
						.entrySet().iterator();
				int count = 0;
				while (dealIter.hasNext()) {
					Entry<String, ArrayList<LineOfBusiness>> entry = dealIter
							.next();
					
					d = new Deal120x600(entry.getValue(),
							((Hotel) entry.getValue().get(0))
							.isHottestDeal(), config);
					deals.add(d);
					dealParents.add(d);

					// if it's the first item, we have to add it again
					// to
					// support the animation loop
					if (count == 0) {
						d = new Deal120x600(entry.getValue(),
								((Hotel) entry.getValue().get(0))
										.isHottestDeal(), config);
					}
					count++;
				}
				deals.add(d);
				dealParents.add(d);
				DealViewData dealViewData = new DealViewData(dealParents,
						config, searchFormUserValues);

				try {
					dealView = new DealViewSlider(dealViewData);
				} catch (Exception e) {

					System.err.println("Problem dealview!");
					System.out.println(e.getMessage());
					System.out.println(e.getCause());
					System.out.print(e.getStackTrace().toString());

				}
				try {
					dealView.addSearchHandler(new DealsSearchListener() {

						@Override
						public void onSearch() {

							searchFormUserValues.set(dealView.getSearchCity(),
									searchFormUserValues.getDate(),
									searchFormUserValues.getNights());
							reloadData(searchFormUserValues.getCity(),
									searchFormUserValues.getDate(),
									searchFormUserValues.getNights(), true);

						}

					});
				} catch (Exception e) {

					System.err.println("Problem listener!");
					System.out.println(e.getMessage());
					System.out.println(e.getCause());
					System.out.print(e.getStackTrace().toString());

				}
				try {
					hideLoadingPanel();
					panel.add(dealView, 5,
							15);
				} catch (Exception e) {

					System.err.println("Problem panel add!");
					System.out.println(e.getMessage());
					System.out.println(e.getCause());
					System.out.print(e.getStackTrace().toString());

				}
				try {
					
				} catch (Exception e) {

					System.err.println("Problem hide panel!");
					System.out.println(e.getMessage());
					System.out.println(e.getCause());
					System.out.print(e.getStackTrace().toString());

				}

			}

			@Override
			public void onFail() {
				hideLoadingPanel();
				GoogleAnalytics.trackApiFailure(api.getFailureApiCall());
				panel.add(getFailurePanel(getExpediaUrlWithTracking(),
						config.getWidth(), config.getHeight()), 0, ((config
						.getHeight() / 2) - 20));
			}

		});

		reloadData(searchFormUserValues.getCity(),
				searchFormUserValues.getDate(),
				searchFormUserValues.getNights(), true);
		// api.getData(searchFormUserValues.getCity(),
		// searchFormUserValues.getDate(), searchFormUserValues.getNights(),
		// true);

	}
	private void reloadData(Destination city, Date date, int nights,
			boolean resetCalls) {
		showLoadingPanel();
		api.clearMergedHotels();
		api.getData(city, date, nights, resetCalls);
	}

	

	private void hideLoadingPanel() {
		loadingPanel.setVisible(false);
		panel.remove(0);
		//layout.addHeaderLogo(panel, getExpediaUrlWithTracking());
		//layout.setBackground(panel);

	}

	private String getExpediaUrlWithTracking() {

		String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
				+ Configuration.getNetworkTracking().replace("?", "&")
				+ "&finalurl=";
		trackingRedirect = trackingRedirect
				+ Utility.escapeURL(ExpediaBusinessConstants.EXPEDIA_URL);
		return trackingRedirect;

	}
	public Widget getFailurePanel(final String tracking, int width, int height) {
		FocusPanel panel = new FocusPanel();

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.add(new Image(resources.failure()));
		vPanel.setWidth(width + "px");
		Label failLabel = new Label("Search for Expedia Travel");
		vPanel.add(failLabel);
		
	//	vPanel.setStyleName(getSkin().getBaseStyleName());
	//	vPanel.addStyleName(getSkin().getFailureLabelStyleName());
		
	//	failLabel.addStyleName(getSkin().getFailureLabelStyleName());
		panel.add(vPanel);
		panel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO: respect window setting
				Utility.OpenLink(tracking, true);
			}

		});
		return panel;
	}
	
}
