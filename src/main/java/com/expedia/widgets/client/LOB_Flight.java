package com.expedia.widgets.client;


abstract public class LOB_Flight extends LOB {
	final private LOBEnum whichLOB = LOBEnum.Flight;

	

	@Override
	public void setSearchData() {
		this.searchData = new FlightSearchData();
	}

	@Override
	public String getName() {
		return whichLOB.getName();
	}

	@Override
	final public LOBEnum getEnumName() {
		return whichLOB;
	}

	
}