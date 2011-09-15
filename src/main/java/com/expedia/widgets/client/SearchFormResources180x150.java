package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SearchFormResources180x150 extends ClientBundle {
	final String FOLDER = "searchform/";
	final String SUBFOLDER_180x150 = "180x150/";

	
	@Source(FOLDER + SUBFOLDER_180x150 + "canvas180x150b.png")
	ImageResource canvas180x150();
	
	@Source(FOLDER + "searchform180x150.css")
	CssResource myCss();
	

	@Source(FOLDER + "booknow71x24.png")
	ImageResource search();

	@Source(FOLDER + "booknow71x24MouseOver.png")
	ImageResource searchMouseOver();

	@Source(FOLDER + "booknow92x33.png")
	ImageResource search92x33();
	
	@Source(FOLDER + "flashlight124x33.png")
	ImageResource flashlight();
	
	@Source(FOLDER + "expediaLogo82x24_kayak.png")
	ImageResource expediaLogoKayak();
}

