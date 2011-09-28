package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface SearchFormResources300x250 extends ClientBundle {

	final String FOLDER = "searchform/";
	final String SUBFOLDER_300x250 = "300x250/";
	final String LOGOSFOLDER = "logos/";
	
	final String SUBFOLDER = "searchform/";
	
	@Source(FOLDER + SUBFOLDER_300x250 + "canvas300x250.png")
	ImageResource canvas300x250();
	
	@Source(FOLDER + "booknow92x33.png")
	ImageResource search92x33();
	
	@Source(FOLDER + "booknow92x33MouseOver.png")
	ImageResource searchMouseOver92x33();
	
	@Source(FOLDER + "flashlight124x33.png")
	ImageResource flashlight();
	
	@Source(FOLDER + SUBFOLDER_300x250 + LOGOSFOLDER + "expediaLogo.png")
	ImageResource expediaLogoHorizontal135x37();
	
	@Source(FOLDER + SUBFOLDER_300x250 + "searchform300x250.css")
	CssResource myCss300x250();
	

}
