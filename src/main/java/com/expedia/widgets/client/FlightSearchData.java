package com.expedia.widgets.client;

import java.util.Date;

import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;

public class FlightSearchData implements SearchData {
	private String leavingFrom = new String();
	private String goingTo = new String();
	private Date departingDate = new Date();
	private String departingTime = new String();
	private Date returningDate = new Date();
	private String returningTime = new String();
	private String numAdults = new String();
	private String numChildren = new String();
	private String numSeniors = new String();

	@Override
	public String getSearchUrl() {

		String url = Configuration.getPOS().getExpediaBaseUrl()
				+ "/pubspec/scripts/eap.asp?GOTO=EXPFLTWIZ"
				+ "&FrAirport="
				+ URL.encode(leavingFrom)
				+ "&ToAirport="
				+ URL.encode(goingTo)
				+ "&FromDate="
				+ URL.encode(DateTimeFormat.getFormat(
						Configuration.getPOS().getDateFormat()).format(
						departingDate))
				+ "&FromTime="
				+ URL.encode(departingTime)
				+ "&ToDate="
				+ URL.encode(DateTimeFormat.getFormat(
						Configuration.getPOS().getDateFormat()).format(
						returningDate)) + "&ToTime="
				+ URL.encode(returningTime) + "&NumAdult="
				+ URL.encode(numAdults) + "&NumChild="
				+ URL.encode(numChildren) + "&NumSenior="
				+ URL.encode(numSeniors);

		String trackingRedirect = TrackingConstants.TRACKING_REDIRECT + "?"
				+ Configuration.getNetworkTracking().replace("?", "&")
				+ "&finalurl=";
		trackingRedirect = trackingRedirect + Utility.escapeURL(url);

		return trackingRedirect;

	}

	public void setFromAirport(String fromAirport) {
		this.leavingFrom = fromAirport;
	}

	public void setToAirport(String toAirport) {
		this.goingTo = toAirport;
	}

	public void setDepartDate(Date checkin) {
		this.departingDate = checkin;
	}

	public void setDepartureTime(String time) {
		this.departingTime = time;
	}

	public void setReturnDate(Date checkout) {
		this.returningDate = checkout;
	}

	public void setReturnTime(String time) {
		this.returningTime = time;
	}

	public void setNumberOfAdults(String numAdults) {
		this.numAdults = numAdults;
	}

	public void setNumberOfChildren(String numChildren) {
		this.numChildren = numChildren;
	}

	public void setNumberOfSeniors(String numSeniors) {
		this.numSeniors = numSeniors;
	}

}
