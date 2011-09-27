package com.expedia.widgets.client;


import com.google.gwt.user.client.ui.Image;

/**
 * @author stevie.sellers
 * 
 */
public class SearchFormLOBSelectorButton120x600 extends
		SearchFormLOBSelectorButton {

	public SearchFormLOBSelectorButton120x600(
			LineOfBusinessConfiguration config) {
		super(config);

	}

	@Override
	protected void setRight() {
		if (lobs.size() > 1) {
			right = new ArrowMarkerSearchForm120x600(0, true, null,
					true, getConfig().getLinesOfBusiness().get(0));
		} else {
			right = new ArrowMarkerSearchForm120x600(0, true, null,
					false, getConfig().getLinesOfBusiness().get(0));
		}
	}

	@Override
	protected void setLeft() {
		if (lobs.size() > 1) {
			left = new ArrowMarkerSearchForm120x600(0, false, null,
					true, getConfig().getLinesOfBusiness().get(0));
		} else {
			left = new ArrowMarkerSearchForm120x600(0, false, null,,
					false, getConfig().getLinesOfBusiness().get(0));
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
		return lob.getIcon(getSkin());
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
