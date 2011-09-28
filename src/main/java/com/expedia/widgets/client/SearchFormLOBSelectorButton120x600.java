package com.expedia.widgets.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;

/**
 * @author stevie.sellers
 * 
 */
public class SearchFormLOBSelectorButton120x600 extends
		SearchFormLOBSelectorButton {

	
	
	@Inject
	public SearchFormLOBSelectorButton120x600(
			LineOfBusinessConfiguration config) {
		super(config);

	}

	@Override
	protected void setRight() {
		if (lobs.size() > 1) {
			System.err.println("Size is " + getConfig().getLinesOfBusiness().get(0));
		//	Image i = new Image(resources.selectorButtonRight22x49Full());
			System.err.println("resources are " + resources.toString());
			//System.err.println("Image is " + i.toString());
			right = new ArrowMarkerSearchForm120x600(0, true, "",
					true, getConfig().getLinesOfBusiness().get(0),  new Image(resources.selectorButtonRight22x49Full()), new Image(resources.selectorButtonRightNoArrow22x49Full()), new Image(resources.selectorButtonLeft22x49Full()), new Image(resources.selectorButtonLeftNoArrow22x49Full()));
		} else {
			right = new ArrowMarkerSearchForm120x600(0, true, null,
					false, getConfig().getLinesOfBusiness().get(0), new Image(resources.selectorButtonRight22x49Full()), new Image(resources.selectorButtonRightNoArrow22x49Full()), new Image(resources.selectorButtonLeft22x49Full()), new Image(resources.selectorButtonLeftNoArrow22x49Full()));
		}
	}

	@Override
	protected void setLeft() {
		if (lobs.size() > 1) {
			left = new ArrowMarkerSearchForm120x600(0, false, null,
					true, getConfig().getLinesOfBusiness().get(0),  new Image(resources.selectorButtonRight22x49Full()), new Image(resources.selectorButtonRightNoArrow22x49Full()), new Image(resources.selectorButtonLeft22x49Full()), new Image(resources.selectorButtonLeftNoArrow22x49Full()));
		} else {
			left = new ArrowMarkerSearchForm120x600(0, false, null,
					false, getConfig().getLinesOfBusiness().get(0),  new Image(resources.selectorButtonRight22x49Full()), new Image(resources.selectorButtonRightNoArrow22x49Full()), new Image(resources.selectorButtonLeft22x49Full()), new Image(resources.selectorButtonLeftNoArrow22x49Full()));
		}
	}

	@Override
	protected int getImageTop() {
		return 0;
	}

	@Override
	protected int getImageLeft() {
		return 18;
	}

	@Override
	protected Image getLOBIcon(LOBEnum lob) {
		return lob.getIcon(new LineOfBusinessSkin300x250());
	}

	@Override
	protected int getImageWidth() {
		return 55;
	}

	@Override
	protected int getImageHeight() {
		return 44;
	}

}
