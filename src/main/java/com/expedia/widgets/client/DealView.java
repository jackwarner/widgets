package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;


/**
 * A deal view consists of one or more "Deals", each of which consists of one or
 * more "Offers".
 * 
 * This structure is required to accomodate looping (via animation) through a
 * number of deals. For example, a single @DealViewParent subclass could have
 * multiple
 * 
 * @DealParent, each of which displayed offers in a single city or matching a
 *              certain criteria.
 * 
 *              This class should be @WidgetLayout independent. However, @DealParent
 *              classes will be specific to a particular ad size and/or layout.
 * 
 * @author jack.warner
 * 
 */
abstract public class DealView extends Composite {

	private final int width;
	private int height;

	protected AbsolutePanel parentPanel = new AbsolutePanel();
	protected final ArrayList<Widget> deals = new ArrayList<Widget>();
	
	protected HandlerManager handlerManager = new HandlerManager(this);
	@Inject
	public DealView(final ArrayList<Deal> deals, int myWidth, int myHeight
			) {

		this.deals.addAll(deals);
		this.width = myWidth;
		this.height = myHeight;

		parentPanel.setSize(myWidth + "px", myHeight + "px");

	}

	protected int getWidth() {
		return width;
	}

	protected int getHeight() {
		return height;
	}

	public void addSearchHandler(DealsSearchListener handler) {
		handlerManager.addHandler(DealsSearchEvent.getType(), handler);
	}

	public Destination getSearchCity() {
		// If the deal view implements a search using a city, the subclass needs
		// to override this method
		return null;
	}

	public Date getSearchDate() {

		return null;
	}

	public int getNumberOfNights() {

		return 0;
	}
}
