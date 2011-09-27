/**
 * 
 */
package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author jackwarner
 *
 */
public class LOBFactory {
	private final LineOfBusinessConfiguration config;
	ArrayList<LOB> lobs = new ArrayList<LOB>();
	LOB currentLOB;

	public LOBFactory(
			LineOfBusinessConfiguration config) {
		this.config = config;
		
	}

	public ArrayList<LOB> getLOBs() {

		Iterator<LOBEnum> lobList = config.getLinesOfBusiness().iterator();

		while (lobList.hasNext()) {

			// TODO: be explicit about which sizes/layouts are supported and
			// dont try to create them if not
			// that or throw a big exception when a null value is returned

			LOBEnum current = lobList.next();
		/*	if (current.equals(LOBEnum.Activities)) {

				final LOB_Activities activitiesLayout = layout.Activities();
				lobs.add(activitiesLayout);

			} else if (current.equals(LOBEnum.Car)) {

				final LOB_Car carLayout = layout.Car();
				lobs.add(carLayout);

			} else if (current.equals(LOBEnum.Cruise)) {

				final LOB_Cruise cruiseLayout = layout.Cruise();
				lobs.add(cruiseLayout);

			} else if (current.equals(LOBEnum.Flight)) {

				final LOB_Flight flightLayout = layout.Flight();
				lobs.add(flightLayout);

			} else if (current.equals(LOBEnum.FlightCar)) {

				final LOB_FlightCar flightCarLayout = layout.FlightCar();
				lobs.add(flightCarLayout);

			} else if (current.equals(LOBEnum.FlightHotel)) {

				final LOB_FlightHotel flightHotelLayout = layout.FlightHotel();
				lobs.add(flightHotelLayout);

			} else if (current.equals(LOBEnum.FlightHotelCar)) {
				final LOB_FlightHotelCar flightHotelCarLayout = layout
						.FlightHotelCar();
				lobs.add(flightHotelCarLayout);

			} else if (current.equals(LOBEnum.Hotel)) {
				final LOB_Hotel hotelLayout = layout.Hotel();
				lobs.add(hotelLayout);
			} else if (current.equals(LOBEnum.HotelCar)) {

				final LOB_HotelCar hotelCarLayout = layout.HotelCar();
				lobs.add(hotelCarLayout);

			} else if (current.equals(LOBEnum.PackageHolidays)) {
				final LOB_PackageHolidays packageHolidaysLayout = layout
						.PackageHolidays();
				lobs.add(packageHolidaysLayout);

			} else {
				System.err.println(current
						+ " could not be found as an existing LOB");
			}*/
		}
		

		return lobs;
	}

}