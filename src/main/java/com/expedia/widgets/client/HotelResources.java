package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;


public interface HotelResources extends ClientBundle{
	// a DataResource is resizable, an ImageResource is not
	@Source("dynamicad/filler_hotel_image.png")
	DataResource fillerHotel();
}
