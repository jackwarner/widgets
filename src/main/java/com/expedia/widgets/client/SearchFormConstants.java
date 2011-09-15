package com.expedia.widgets.client;

import java.util.Map;

import com.google.gwt.i18n.client.Constants;

public interface SearchFormConstants extends Constants {
	@DefaultStringMapValue({ "_flights", "Flights", "_cars", "Cars",
			"_activities", "Activities", "_cruises", "Cruises", "_flightcar",
			"Flight + Car", "_flighthotel", "Flight + Hotel",
			"_flighthotelcar", "Flight + Hotel + Car", "_hotels", "Hotels",
			"_hotelcar", "Hotel + Car", "_packageholidays", "Package Holidays" })
	Map<String, String> lobMap();

	@Meaning("The value for the inside of Hotel Destination search box, if implemented.")
	@DefaultStringValue("Airport")
	String getDefaultFlightText();

	@Meaning("The leaving from label")
	@DefaultStringValue("Leaving from")
	String LeavingFrom();

	@DefaultStringValue("Going to")
	String GoingTo();

	@DefaultStringValue("Departing")
	String DepartingDate();

	@DefaultStringValue("Time")
	String DepartingTime();

	@DefaultStringValue("Returning")
	String ReturningDate();

	@DefaultStringValue("Time")
	String Time();

	@DefaultStringValue("Adults")
	String NumberOfAdults();

	@DefaultStringValue("Adult (18-64)")
	String NumberOfAdultsWithAge();

	@DefaultStringValue("Children")
	String NumberOfChildren();

	@DefaultStringValue("Children (0-17)")
	String NumberOfChildrenWithAge();

	@DefaultStringValue("Seniors")
	String NumberOfSeniors();

	@DefaultStringValue("Seniors (65+)")
	String NumberOfSeniorsWithAge();

	@DefaultStringValue("Destination")
	String Destination();

	@DefaultStringValue("Check-in")
	String Checkin();

	@DefaultStringValue("Check-out")
	String Checkout();

	@DefaultStringValue("Search")
	String Search();

	@DefaultStringValue("Pick-up Location")
	String PickupLocation();

	@DefaultStringValue("Pick-up")
	String Pickup();

	@DefaultStringValue("Pick-up Date")
	String PickupDate();

	@DefaultStringValue("Drop-off Date")
	String DropoffDate();

	@DefaultStringValue("Car Type")
	String CarType();

	@DefaultStringValue("Location")
	String Location();

	@DefaultStringValue("From")
	String From();

	@DefaultStringValue("To")
	String To();

	@DefaultStringValue("Departure")
	String Departure();

	@DefaultStringValue("Earliest Date")
	String EarliestDate();

	@DefaultStringValue("Latest Date")
	String LatestDate();

	@DefaultStringValue("Earliest Departure")
	String EarliestDeparture();

	@DefaultStringValue("Earliest Return")
	String EarliestReturn();
	
	@DefaultStringValue("Return")
	String EarliestReturnShortened();
	
	@DefaultStringValue("Departure")
	String EarliestDepartureShortened();

	@DefaultStringValue("Duration")
	String Duration();

	@DefaultStringValue("Child Age")
	String ChildAge();

	/*
	 * For the US only - they don't need translations
	 */
	@DefaultStringValue("Departure Month")
	String DepatureMonth();

	@DefaultStringValue("Cruise Line")
	String CruiseLine();

	@DefaultStringValue("Cruise Length")
	String CruiseLength();

	@DefaultStringValue("Previous Cruiser")
	String PreviousCruiser();

	@DefaultStringValue("Carnival")
	String Carnival();

	/*
	 * end US only
	 * 
	 * @return
	 */
	@DefaultStringValue("Anytime")
	String Anytime();

	@DefaultStringValue("Morning")
	String Morning();

	@DefaultStringValue("Noon")
	String Noon();

	@DefaultStringValue("Evening")
	String Evening();

	@DefaultStringValue("No Preference")
	String NoPreference();

	@DefaultStringValue("Economy")
	String Economy();

	@DefaultStringValue("Compact")
	String Compact();

	@DefaultStringValue("Midsize")
	String Midsize();

	@DefaultStringValue("Standard")
	String Standard();

	@DefaultStringValue("Full Size")
	String FullSize();

	@DefaultStringValue("Premium")
	String Premium();

	@DefaultStringValue("Luxury")
	String Luxury();

	@DefaultStringValue("Convertible")
	String Convertible();

	@DefaultStringValue("Minivan")
	String Minivan();

	@DefaultStringValue("SUV")
	String SUV();

	@DefaultStringValue("Sports Car")
	String SportsCar();

}
