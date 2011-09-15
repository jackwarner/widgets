package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum PointOfSale {

	US("http://www.expedia.com", "us", "com", "MM/dd/yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.Cruise);
					add(LOBEnum.Activities);
				}
			}), UK("http://www.expedia.co.uk", "uk", "co.uk", "dd/MM/yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.PackageHolidays);
					add(LOBEnum.Activities);
				}
			}), AU("http://www.expedia.com.au", "au", "com.au", "dd/MM/yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.FlightHotelCar);
					add(LOBEnum.FlightCar);
					add(LOBEnum.HotelCar);
					add(LOBEnum.Activities);
				}
			}), FR("http://www.expedia.fr", "fr", "fr", "dd/MM/yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.PackageHolidays);
					add(LOBEnum.Activities);
				}
			}), DE("http://www.expedia.de", "de", "de", "dd.MM.yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.PackageHolidays);
					add(LOBEnum.Activities);
				}
			}), IT("http://www.expedia.it", "it", "it", "dd/MM/yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.PackageHolidays);
					add(LOBEnum.Activities);
				}
			}), NL("http://www.expedia.nl", "nl", "nl", "dd-MM-yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), ES("http://www.expedia.es", "es", "es", "dd/MM/yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), NO("http://www.expedia.no", "no", "no", "dd.MM.yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), DK("http://www.expedia.dk", "dk", "dk", "dd.MM.yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), SE("http://www.expedia.se", "se", "se", "yyyy-M-dd",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), AT("http://www.expedia.at", "at", "at", "dd.MM.yyyy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.PackageHolidays);
				}
			}), IE("http://www.expedia.ie", "ie", "ie", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.Activities);
				}
			}), BE("http://www.expedia.be", "be", "be", "dd-MM-yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.Activities);
				}
			}), CA("http://www.expedia.ca", "ca", "ca", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
					add(LOBEnum.FlightHotelCar);
					add(LOBEnum.FlightCar);
					add(LOBEnum.HotelCar);
					add(LOBEnum.Activities);
				}
			}), NZ("http://www.expedia.co.nz", "nz", "co.nz", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.Car);
				}
			}), IN("http://www.expedia.co.in", "in", "co.in", "dd-MM-yy",
			new ArrayList<LOBEnum>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Flight);
				}
			}),
	// no JP support
	MX("http://www.expedia.com.mx", "mx", "com.mx", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
		 * 
		 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Car);
					add(LOBEnum.HotelCar);
					add(LOBEnum.Activities);
				}
			}), SG("http://www.expedia.com.sg", "sg", "com.sg", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
		 * 
		 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
				}
			}), JP("http://www.expedia.co.jp", "jp", "co.jp", "dd/MM/yy",
			new ArrayList<LOBEnum>() {
				/**
		 * 
		 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
				}
			}), TEST("http://www.expedia.com", "test", "com", "MM/dd/yy",
			new ArrayList<LOBEnum>() {
				/**
		 * 
		 */
				private static final long serialVersionUID = 1L;

				{
					add(LOBEnum.Hotel);
					add(LOBEnum.Car);
					add(LOBEnum.HotelCar);
					add(LOBEnum.Activities);
					add(LOBEnum.Cruise);
					add(LOBEnum.Flight);
					add(LOBEnum.FlightHotel);
					add(LOBEnum.FlightHotelCar);
					add(LOBEnum.FlightCar);
				}
			});
	// no MY support

	private final String expediaBaseUrl;
	private final String pos;
	private final String dateFormat;
	private final String tld;
	private ArrayList<LOBEnum> allowedLobs;

	private PointOfSale(String expediaBaseUrl, String pos,
			String topLevelDomain, String dateFormat,
			ArrayList<LOBEnum> allowedLOBs) {
		this.expediaBaseUrl = expediaBaseUrl;
		this.pos = pos;
		this.dateFormat = dateFormat;
		this.tld = topLevelDomain;
		this.allowedLobs = allowedLOBs;
	}

	public String getExpediaBaseUrl() {
		return expediaBaseUrl;
	}

	private static final Map<String, PointOfSale> lookup = new HashMap<String, PointOfSale>();

	static {
		for (PointOfSale p : EnumSet.allOf(PointOfSale.class))
			lookup.put(p.pos, p);
	}

	public ArrayList<LOBEnum> getAllowedLinesOfBusiness() {
		return allowedLobs;
	}

	public static PointOfSale get(String pos) {
		return lookup.get(pos);
	}

	public String getTwoLetterPOSCode() {
		return this.pos;
	}

	public String getTopLevelDomain() {
		return this.tld;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}
}