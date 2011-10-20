package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * DealView is responsible for animating multiple hotel deals for a single city.
 * 
 * @author jack.warner
 * 
 */
public class DealViewSlider extends DealView {

	final private HandlerManager handlerManager = new HandlerManager(this);
	private AbsolutePanel bigPanel = new AbsolutePanel();
	private AbsolutePanel panel = new AbsolutePanel();

	private ArrowMarker leftArrow;
	private ArrowMarker rightArrow;
	private ArrayList<Deal> deals = new ArrayList<Deal>();

	VerticalPanel optionsBar = new VerticalPanel();
	private int widgetAnimationIndex = -1;
	Iterator<Deal> dealsIter = null;

	ListBox cityList;
	DateBox dateBox;
	ListBox numberNights;
	private SearchForm miniSearch;
	private ArrayList<String> destinations = new ArrayList<String>();
	final private SearchFormValues userFormValues;
	final private DealViewData myData;

	private Timer timer;
	private Deal backgroundDeal; // used for looping

	public DealViewSlider(DealViewData data) {
		super(data.getDeals(), data.getWidth(), data.getHeight());

		this.myData = data;
		this.destinations.clear();

		this.deals = data.getDeals();
		// this.dealMarker = new ArrayList<PositionMarker>();

		userFormValues = data.getSearchFormUserValues();

		if (this.deals == null) {
			System.err.println("Deals are null");
		} else if (this.deals.size() <= 1) {
			System.err.println("Two or more deals are required for this view.");
		} else {
			// set a background deal that will always be there -
			// this creates the impression of looping
			panel.setPixelSize(110,600);
			// Debug.print("Deals size is " + this.deals.size());
			backgroundDeal = this.deals.get(deals.size() - 1);
			panel.add(backgroundDeal, 0, 0);

			// background deal is set - now add the remaining deals
			deals.remove(deals.size() - 1);
			dealsIter = this.deals.iterator();

			while (dealsIter.hasNext()) {
				Deal w = dealsIter.next();
				// this.destinations.add(w.getName());
				panel.insert(w, 0, 0, 1);
			}
			(deals.get(0)).animateDeal();
			try {
				// System.out.println("Attempting to animate deal " +
				// deals.get(0).getName());
				deals.get(0).runLoadAnimation();
			} catch (Exception e) {
				System.err.println("Unable to animate first deal.");
			}

			// Debug.print("Deals size is " + this.deals.size());

			widgetAnimationIndex = 0;
			timer = new Timer() {
				@Override
				public void run() {

					if (widgetAnimationIndex >= deals.size()) {
						/*
						 * Debug.print(
						 * "We've hit the end of the road: Deals size = " +
						 * deals.size());
						 */
						// leave the background in tact, clear the remaining
						// widgets, and reposition them
						widgetAnimationIndex = 0;
						// updateNavigationMarker();

						// stop the previous animation
						(deals.get((deals.size() - 1))).stopAnimation();

						Iterator<Deal> dealsIterator = deals.iterator();
						while (dealsIterator.hasNext()) {
							panel.setWidgetPosition(dealsIterator.next(), 0, 0);
						}
					}
					try {
						deals.get(widgetAnimationIndex + 1).runLoadAnimation();
					} catch (Exception e) {
						// System.err.println("Couldnt do load animation.");
						try {
							backgroundDeal.runLoadAnimation();
						} catch (Exception e2) {
							System.err.println("Unable to animate final deal.");
						}
					}
					try {
						(deals.get(deals.size() - 1)).stopAnimation();
					} catch (Exception e) {
						System.out.println("Unable to stop final animation.");
					}
					// TODO: dont create new animation object for each run of
					// the timer
					AnimationMoveBy moveBy = new AnimationMoveBy(panel,
							deals.get(widgetAnimationIndex), 0, getWidth());
					moveBy.run(500);

					try {
						// if ()
						if (deals.get(widgetAnimationIndex) != null) {
							(deals.get(widgetAnimationIndex)).stopAnimation();
						}
						if ((widgetAnimationIndex + 1) < deals.size()) {
							// if (deals.get(widgetAnimationIndex+1) != null) {
							(deals.get(widgetAnimationIndex + 1)).animateDeal();
						} else {
							// Debug.print("Hit animate background");
							backgroundDeal.animateDeal();
						}
					} catch (Exception e) {
						System.err.println("Failed animation work: "
								+ widgetAnimationIndex + " and size of "
								+ deals.size());
					}
					widgetAnimationIndex++;
					updateNavigationMarker(widgetAnimationIndex, false);
				}

				// }
			};
			;
			this.myData.getConfig();
			if (Configuration.isAnimated()) {
				this.myData.getConfig();
				timer.scheduleRepeating(DealsWidgetConfiguration
						.getAnimationInterval() * 1000);
			}

		}
		bigPanel.setPixelSize(110, 600);
		bigPanel.add(panel, 0, 80);
		bigPanel.add(getNavigationMarkers(), 0, 570);

		miniSearch = new SearchFormSimple(userFormValues, 92);
		miniSearch.addSearchHandler(new SearchListener() {
			@Override
			public void onMiniSearch() {
				timer.cancel();
				// data.getConfi
				myData.getConfig().setAnimated(false);
				handlerManager.fireEvent(new DealsSearchEvent());
			}
		});
		bigPanel.add(miniSearch, 9, 36);

		initWidget(bigPanel);

	}

	@Override
	public void addSearchHandler(DealsSearchListener handler) {
		handlerManager.addHandler(DealsSearchEvent.getType(), handler);
	}

	private HorizontalPanel getNavigationMarkers() {

		HorizontalPanel navigationPanel = new HorizontalPanel();

		navigationPanel.setPixelSize(110, 22);
		navigationPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		navigationPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		navigationPanel.addStyleName(myData.getConfig().getSkin()
				.getNavigationMarkers());
		// destinations.add(0, "Hottest Deals");

		// leftSpace.setPixelSize(padWidth, 1);
		// AbsolutePanel rightSpace = new AbsolutePanel();
		// rightSpace.setPixelSize(padWidth, 1);

		leftArrow = new ArrowMarker(0, false, null);
		leftArrow.getImage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GoogleAnalytics.trackDotClick(leftArrow.getDestinationName());
				// resetWidgetPositions();

				goToDealAtPosition(leftArrow.getPosition());
			}

		});
		navigationPanel.add(leftArrow);

		rightArrow = new ArrowMarker(0, true, null);
		rightArrow.getImage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GoogleAnalytics.trackDotClick(rightArrow.getDestinationName());
				// resetWidgetPositions();

				goToDealAtPosition(rightArrow.getPosition());
			}

		});
		navigationPanel.add(rightArrow);
		updateNavigationMarker(0, true);

		// navigationPanel.add(rightSpace);

		return navigationPanel;
	}

	private void goToDealAtPosition(int position) {

		timer.cancel();

		int j = 0;

		Iterator<Deal> dealsIterator = deals.iterator();
		while (dealsIterator.hasNext()) {
			Deal w = dealsIterator.next();
			w.stopAnimation();
			try {
				w.runLoadAnimation();
			} catch (Exception e) {
				System.err.println("Unable to animate deal on action.");
			}

			if (j == position) {
				w.setVisible(true);
				try {
					miniSearch.setSelectedDestination(w.getName());
					System.out.println(w.getName());
					// data.getSearchFormUserValues().set(new
					// Destination("Cancun", "Cancun", true));
				} catch (Exception e) {
					System.err.println("Unable to set city");
				}
				panel.setWidgetPosition(w, 0, 0);

			} else {
				w.setVisible(false);
				backgroundDeal.setVisible(false);

			}
			j++;
		}

		updateNavigationMarker(position, false);

	}

	/**
	 * This updates the navigation markers to
	 */

	private void updateNavigationMarker(int currentPosition, boolean isFirst) {

		int rightPosition = currentPosition % deals.size() + 1;
		if (rightPosition >= deals.size()) {
			rightPosition -= deals.size();
		}
		rightArrow.setPosition(rightPosition);

		rightArrow.setDestinationName(deals.get(rightArrow.getPosition())
				.getName());
		int leftPosition = currentPosition % deals.size() - 1;

		if (leftPosition < 0) {
			leftPosition += deals.size();
		}
		leftArrow.setPosition(leftPosition);
		leftArrow.setDestinationName(deals.get(leftArrow.getPosition())
				.getName());

		if (!isFirst) {
			miniSearch.setSelectedDestination(deals.get(
					currentPosition % deals.size()).getName());
		}

	}

	@Override
	public Destination getSearchCity() {
		return userFormValues.getCity();
	}

	@Override
	public Date getSearchDate() {
		return userFormValues.getDate();
	}

	@Override
	public int getNumberOfNights() {
		return userFormValues.getNights();
	}

}
