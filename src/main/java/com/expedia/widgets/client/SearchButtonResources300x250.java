package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface SearchButtonResources300x250 extends ClientBundle {

	final String FOLDER = "searchform/";
	final String SUBFOLDER_300x250 = "300x250/";
	final String LOGOSFOLDER = "logos/";
	
	final String SUBFOLDER = "searchform/";

	@Source(FOLDER + "booknow92x33.png")
	ImageResource search92x33();
	
	@Source(FOLDER + "booknow92x33MouseOver.png")
	ImageResource searchMouseOver92x33();
	
	@Source(FOLDER + "flashlight124x33.png")
	ImageResource flashlight();
	
}
