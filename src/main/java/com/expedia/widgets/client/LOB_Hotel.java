package com.expedia.widgets.client;


abstract public class LOB_Hotel extends LOB {

	final private LOBEnum whichLOB = LOBEnum.Hotel;


	@Override
	protected void setSearchData() {
		this.searchData = new HotelSearchData();
	}

	/**
	 * The localized name of this line of business
	 */
	@Override
	public String getName() {
		return whichLOB.getName();
	}

	@Override
	final public LOBEnum getEnumName() {
		return whichLOB;
	}

}
