/**
 * 
 */
package com.expedia.widgets.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;

/**
 * @author jackwarner
 *
 */
public abstract class LineOfBusinessSelector extends Composite {

	final private HandlerManager handlerManager = new HandlerManager(this);
	private LOBEnum selectedLOB = LOBEnum.Hotel;

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
