package com.expedia.widgets.client;


public class LineOfBusinessPanels300x250 implements LineOfBusinessPanelMaker {

	@Override
	public LOB getFlightPanel() {
		return new FlightSearchPanel300x250();
	}

	@Override
	public LOB_Hotel getHotelPanel() {
		return new HotelSearchPanel300x250();
	}

	@Override
	public LOB getActivitiesPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getCarPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getCruisePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getFlightCarPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getFlightHotelPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getFlightHotelCarPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getHotelCarPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LOB getPackageHolidaysPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
