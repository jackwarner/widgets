package com.expedia.widgets.client;



/**
 * Use Google Analytics Event Tracking to gather information about the usage of
 * the widget.
 * 
 * @author jack.warner
 * 
 */
public final class GoogleAnalytics {
	private static native void trackEvent(String category, String action,
			String label) /*-{
							$wnd._gaq.push(['_trackEvent', category, action, label]);
							}-*/;

	/**
	 * Important! The following values are used for reporting. Changing them
	 * will result in report errors!
	 */
	private static String getWidgetCategory() {
		return "Deals_US";
	}

	private static String getOfferAction() {
		return "OfferClick";
	}

	private static String getDotAction = "DotClick";
	private static String getSearchAction = "SearchClick";
	private static String getChangeCityAction = "ChangeCity";
	private static String getMouseOverOfferAction = "MouseOverOffer";
	private static String getMoreOfferAction = "MoreOfferClick";
	private static String getApiFailureAction = "ApiFailure";
	private static String getApiZeroResultsAction = "ApiZeroResults";

	public static void trackOfferClick(String offerUrl) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getOfferAction(),
		//		offerUrl);
	}

	public static void trackDotClick(String destination) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getDotAction,
		//		destination);
	}

	public static void trackSearchClick(String searchParameters) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getSearchAction,
		//		searchParameters);
	}

	public static void trackChangeCity(String searchParameters) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getChangeCityAction,
		//		searchParameters);
	}

	public static void trackMouseOverOffer(String offerUrl) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(),
		//		getMouseOverOfferAction, offerUrl);
	}

	public static void trackMoreOffers(String offerUrl) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getMoreOfferAction,
		//		offerUrl);
	}

	public static void trackApiFailure(String call) {
		//GoogleAnalytics.trackEvent(getWidgetCategory(), getApiFailureAction,
		//		call);
	}

	public static void trackApiZeroResults() {
		//GoogleAnalytics.trackEvent(getWidgetCategory(),
		//		getApiZeroResultsAction, "");

	}
}