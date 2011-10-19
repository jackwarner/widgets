package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * These are the destinations for the dropdown list for the mini-search form at
 * the bottom of the widget.
 * 
 * @author jack.warner
 * 
 */
public final class Destinations {
	public static final ArrayList<Destination> destinations = new ArrayList<Destination>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Destination("Location?", "Location?", true));
			add(new Destination("Hottest Deals", "Hottest Deals", true));
			add(new Destination("Anaheim, California", "Anaheim", true));
			add(new Destination("Arlington, Texas", "Arlington", true));
			add(new Destination("Atlanta, Georgia", "Atlanta", true));
			add(new Destination("Atlantic City, New Jersey", "Atlantic City",
					true));
			add(new Destination("Austin, Texas", "Austin", true));
			add(new Destination("Barcelona, Spain", "Barcelona", true));
			add(new Destination("Boston, Massachusetts", "Boston", true));
			add(new Destination("Cabo San Lucas, Mexico", "Cabo San Lucas",
					true));
			add(new Destination("Cancun, Mexico", "Cancun", true));
			add(new Destination("Chicago, Illinois", "Chicago", true));
			add(new Destination("Dallas, Texas", "Dallas", true));
			add(new Destination("Denver, Colorado", "Denver", true));
			add(new Destination("Dubai, United Arab Emirates", "Dubai", true));
			add(new Destination("Fort Lauderdale, Florida", "Fort Lauderdale",
					true));
			add(new Destination("Honolulu, Hawaii", "Honolulu", true));
			add(new Destination("Houston, Texas", "Houston", true));
			add(new Destination("Key West, Florida", "Key West", true));
			add(new Destination("Lahaina, Hawaii", "Lahaina", true));
			add(new Destination("Las Vegas, Nevada", "Las Vegas", true));
			add(new Destination("London, England", "London", true));
			add(new Destination("Los Angeles, California", "Los Angeles", true));
			add(new Destination("Miami, Florida", "Miami", true));
			add(new Destination("Miami Beach, Florida", "Miami Beach", true));
			add(new Destination("Montego Bay, Jamaica", "Montego Bay", true));
			add(new Destination("Myrtle Beach, South Carolina", "Myrtle Beach",
					true));
			add(new Destination("Nashville, Tennessee", "Nashville", true));
			add(new Destination("New Orleans, Louisiana", "New Orleans", true));
			add(new Destination("New York, New York", "New York", true));
			add(new Destination("Orlando, Florida", "Orlando", true));
			add(new Destination("Palm Beach, Florida", "Palm Beach", true));
			add(new Destination("Paradise Island, Bahamas", "Paradise Island",
					true));
			add(new Destination("Paris, France", "Paris", true));
			add(new Destination("Philadelphia, Pennsylvania", "Philadelphia",
					true));
			add(new Destination("Phoenix, Arizona", "Phoenix", true));
			add(new Destination("Playa del Carmen, Mexico", "Playa del Carmen",
					true));
			add(new Destination("Portland, Oregon", "Portland", true));
			add(new Destination("Puerto Morelos, Mexico", "Puerto Morelos",
					true));
			add(new Destination("Puerto Vallarta, Mexico", "Puerto Vallarta",
					true));
			add(new Destination("Punta Cana, Dominican Republic", "Punta Cana",
					true));
			add(new Destination("Reno, Nevada", "Reno", true));
			add(new Destination("Rome, Italy", "Rome", true));
			add(new Destination("San Antonio, Texas", "San Antonio", true));
			add(new Destination("San Diego, California", "San Diego", true));
			add(new Destination("San Francisco, California", "San Francisco",
					true));
			add(new Destination("San Juan, Puerto Rico", "San Juan", true));
			add(new Destination("Scottsdale, Arizona", "Scottsdale", true));
			add(new Destination("Seattle, Washington", "Seattle", true));
			add(new Destination("Singapore, Singapore", "Singapore", true));
			add(new Destination("Tampa, Florida", "Tampa", true));
			add(new Destination("Tokyo, Japan", "Tokyo", true));
			add(new Destination("Vancouver, Canada", "Vancouver", true));
			add(new Destination("Wailea (Maui), Hawaii", "Wailea", true));
			add(new Destination("Washington, D.C.", "Washington", true));

		}
	};

	public static final ArrayList<Destination> getDestinations() {
		Iterator<Destination> destIter = destinations.iterator();
		ArrayList<Destination> filteredDestinations = new ArrayList<Destination>();
		while (destIter.hasNext()) {
			Destination d = destIter.next();
			if (d.hasEnoughDestinations()) {
				filteredDestinations.add(d);
			}
		}
		return filteredDestinations;
	}

	public static final ArrayList<String> getDestinationsStrings() {
		ArrayList<String> stringDestinations = new ArrayList<String>();
		Iterator<Destination> destIter = getDestinations().iterator();

		while (destIter.hasNext()) {
			stringDestinations.add(destIter.next().getValue());
		}
		return stringDestinations;
	}

}
