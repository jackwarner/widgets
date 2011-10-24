package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;


/**
 * This widget includes an optional search form. The parent class captures key
 * data and actions associated with a search form.
 * 
 * Children classes handle UI implementation of a search form.
 * 
 * @author jack.warner
 * 
 */
abstract public class SearchForm extends Composite {
	// private AbsolutePanel footer = new AbsolutePanel();
	// private AbsolutePanel footerHolder = new AbsolutePanel();
	// private AbsolutePanel interactive = new AbsolutePanel();
	protected AbsolutePanel searchPanel = new AbsolutePanel();
	private ArrayList<String> nights = new ArrayList<String>();
	protected final ArrayList<Destination> destinations = new ArrayList<Destination>();

	protected ListBox cityList = new ListBox();
	
	protected ListBox numberNights = new ListBox();
	final HandlerManager handlerManager = new HandlerManager(this);
	protected SearchFormValues searchFormValues;

	public SearchForm(SearchFormValues formValues) {
		/*
		 * if (skin.getName().equals(SkinConstants.ESSENCE_SKIN)) {
		 * runEssence(skin, formValues); } else { run(skin, formValues); }
		 */

		// all search forms set these values:
		// what the user entered:
		searchFormValues = formValues;

		// possible destinations
		destinations.addAll(Destinations.getDestinations());
		destinations.remove(0);
		initDestinationDropDown();
		cityList.setStyleName("miniSearch");
		//cityList.setWidth(layout.getSkin().getDestinationWidth());
		initNightsDropDown();
		initFormValues();

		initWidget(searchPanel);
	}

	public void setSelectedDestination(String name) {

		cityList.setItemSelected(0, true);
		Iterator<Destination> destIter = destinations.iterator();
		int i = 0;
		while (destIter.hasNext()) {
			if (destIter.next().getValue().equals(name)) {

				cityList.setItemSelected(i, true);
				break;
			}
			i++;
		}
	}

	private void initNightsDropDown() {
		nights.add("Nights?");
		nights.add("1");
		nights.add("2");
		nights.add("3");
		nights.add("4");
		nights.add("5");
		nights.add("6");
		nights.add("7");
		nights.add("8");
		nights.add("9");
		nights.add("10");
		Iterator<String> iter = nights.iterator();
		while (iter.hasNext()) {
			numberNights.addItem(iter.next());
		}
	}

	/**
	 * TODO: remove all UI references in this parent class
	 */
	private void initFormValues() {
		try {
			if (destinations.indexOf(getSearchCity()) > -1) {
				cityList.setSelectedIndex(destinations.indexOf(getSearchCity()));
			}
		} catch (Exception e) {
			System.err.println("Problem initializing search form values!");
		}

	}

	private void initDestinationDropDown() {
		Iterator<Destination> iter = destinations.iterator();
		while (iter.hasNext()) {
			Destination d = iter.next();
			cityList.addItem(d.getValue(), d.getValue());
		}
	}

	public void addSearchHandler(SearchListener handler) {
		handlerManager.addHandler(SearchEvent.getType(), handler);
	}

	public Destination getSearchCity() {
		return searchFormValues.getCity();
	}

	public Date getSearchDate() {
		return searchFormValues.getDate();
	}

	public int getSearchNumberOfNights() {
		return searchFormValues.getNights();
	}

}