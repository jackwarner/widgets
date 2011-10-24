package com.expedia.widgets.client;

import java.util.ArrayList;

import com.google.inject.Inject;



/**
 * Contains of the data required by a class of type @DealViewParent.
 * 
 * DealViews need to know which offers, cities, and search form values to use.
 * 
 * @author jack.warner
 * 
 */
public class DealViewData {
	final private ArrayList<Deal> deals = new ArrayList<Deal>();
	final private DealsWidgetConfiguration config;
	final private SearchFormValues searchFormUserValues;
	
	@Inject
	public DealViewData(ArrayList<Deal> deals, DealsWidgetConfiguration config,
			SearchFormValues searchFormUserValues) {
		this.deals.addAll(deals);

		this.config = config;
		this.searchFormUserValues = searchFormUserValues;
		// this.apiDestinations = destinationsFromApi;
	}

	public ArrayList<Deal> getDeals() {
		/*
		 * ArrayList<Deal> deals = new ArrayList<Deal>();
		 * deals.addAll(this.deals); return deals;
		 */
		return this.deals;
	}

	public int getWidth() {
		return config.getWidth();
	}

	public int getHeight() {
		return config.getHeight();
	}

	public SearchFormValues getSearchFormUserValues() {
		return searchFormUserValues;
	}

	

	public DealsWidgetConfiguration getConfig() {
		return config;
	}
}

