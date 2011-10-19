package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;


public class HotelImage extends Composite {
	private HotelResources resources = GWT.create(HotelResources.class);

	public HotelImage(String url, int width, int height) {
		AbsolutePanel panel = new AbsolutePanel();
		Image.prefetch(url);
		panel.setSize(width + "px", height + "px");
		Image backupImage = new Image(resources.fillerHotel().getSafeUri());
		backupImage.setPixelSize(width, height);
		panel.add(backupImage, 0, 0);
		Image realImage = new Image(url);
		realImage.setSize(width + "px", height + "px");
		panel.add(realImage, 0, 0);
		initWidget(panel);
	}
}
