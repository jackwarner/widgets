/**
 * 
 */
package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;

/**
 * @author jackwarner
 *
 */
public abstract class LineOfBusinessSelector extends Composite {

	final private HandlerManager handlerManager = new HandlerManager(this);
	private LOBEnum selectedLOB = LOBEnum.Hotel;
	final protected SelectorResources resources = GWT
			.create(SelectorResources.class); 

	protected void setSelection(LOBEnum selection) {
		selectedLOB = selection;
		handlerManager.fireEvent(new LOBChangedEvent());

	}

	public void addLOBChangedHandler(LOBListener handler) {
		handlerManager.addHandler(LOBChangedEvent.getType(), handler);
	}

	public LOBEnum getSelectedLOB() {
		return selectedLOB;
	}

}
