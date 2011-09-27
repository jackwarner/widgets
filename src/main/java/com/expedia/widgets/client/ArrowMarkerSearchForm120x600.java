package com.expedia.widgets.client;


public class ArrowMarkerSearchForm120x600 extends ArrowMarkerSearchForm {

	final private int width = 22;
	final private int height = 49;

	public ArrowMarkerSearchForm120x600(int position, boolean isRight,
			String title, boolean hasArrow, LOBEnum lobEnum) {
		super(position, isRight, title, hasArrow, lobEnum);
		setSize(width, height);
	}

}
