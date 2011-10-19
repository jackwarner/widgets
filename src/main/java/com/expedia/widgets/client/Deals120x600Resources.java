package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface Deals120x600Resources extends ClientBundle {

	final String FOLDER = "dynamicad/";
	final String SUBFOLDER = "120x600/";

	@Source(FOLDER + "booknow92x33.png")
	ImageResource bookNow();

	@Source(FOLDER + "booknow92x33MouseOver.png")
	ImageResource bookNowHover();

	@Source(FOLDER + SUBFOLDER + "expediaLogo82x24Deals.png")
	ImageResource expediaLogo();

	@Source(FOLDER + SUBFOLDER + "canvas120x600.png")
	ImageResource canvas();

	
	@Source(FOLDER + "left_arrow7x13.png")
	ImageResource leftArrow();

	@Source(FOLDER + "right_arrow7x13.png")
	ImageResource rightArrow();

	@Source(FOLDER + "strikeout25x7.gif")
	DataResource strikeout();

	@Source(FOLDER + "starYellow16x16.png")
	DataResource fullStar();

	@Source(FOLDER + "starHalfYellowHalfGray16x16.png")
	DataResource halfStar();

	@Source(FOLDER + "starGray16x16.png")
	DataResource emptyStar();

	@Source(FOLDER + "flashlight124x33.png")
	ImageResource flashlight();

	@Source(FOLDER + "expedia_loader_logo.png")
	ImageResource expediaLoaderLogo();

	@Source(FOLDER + "hotel.gif")
	ImageResource failure();

	@Source(FOLDER + "expedia_loader.gif")
	ImageResource loader();
	
	
}
