package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Image;

public interface WidgetSkin {

	boolean showEmptyStars();

	Image getEmptyHalfStar();

	Image getHalfStar();

	Image getFullStar();

	Image getEmptyFullStar();

	int getAnimatedStarWidth();

	int getAnimatedStarHeight();

	String getClickable();

	int getStarPanelWidth();

	int getStarPanelHeight();

}
