package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;


public class ArrowMarkerSearchForm120x600 extends ArrowMarkerSearchForm {

	final private int width = 22;
	final private int height = 49;

	@Inject
	public ArrowMarkerSearchForm120x600(int position, boolean isRight,
			String title, boolean hasArrow, LOBEnum lobEnum, Image selectorButtonRight, Image selectorButtonRightNoArrow, Image selectorButtonLeft, Image selectorButtonLeftNoArrow) {
		super(position, isRight, title, hasArrow, lobEnum,  selectorButtonRight,  selectorButtonRightNoArrow,  selectorButtonLeft,  selectorButtonLeftNoArrow);
		setSize(width, height);
	}

}
