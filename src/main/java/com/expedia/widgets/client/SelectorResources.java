package com.expedia.widgets.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;

public interface SelectorResources extends ClientBundle {

	final String FOLDER = "searchform/";
	

	
	@Source(FOLDER  + "selectorButtonLeft22x49Full.png")
	ImageResource selectorButtonLeft22x49Full();
	
	@Source(FOLDER + "selectorButtonRight22x49Full.png")
	ImageResource selectorButtonRight22x49Full();
	
	@Source(FOLDER +  "selectorButtonLeftNoArrow22x49Full.png")
	ImageResource selectorButtonLeftNoArrow22x49Full();
	
	@Source(FOLDER + "selectorButtonRightNoArrow22x49Full.png")
	ImageResource selectorButtonRightNoArrow22x49Full();
	
	@Source(FOLDER +  "selectorButtonMiddle50x49Full.png")
	ImageResource selectorButtonMiddle();
	
	
}