package com.expedia.widgets.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.inject.Inject;

public abstract class LOBSelectionPanel extends Composite {
	final private LineOfBusinessConfiguration config;

	private LOB selectedLOBPanel;
	protected LineOfBusinessSelector selector;
	private FocusPanel fPanel = new FocusPanel();
	protected LineOfBusinessPanelMaker panelMaker;
	private ArrayList<LOB> lobArray = new ArrayList<LOB>();

	@Inject
	public LOBSelectionPanel(final LineOfBusinessConfiguration config) {
		this.config = config;

		
		setSelector();
		try {
			selector.addLOBChangedHandler(new LOBListener() {

				@Override
				public void onChange() {
					Iterator<LOB> myArray = lobArray.iterator();
					while (myArray.hasNext()) {
						LOB myLOB = myArray.next();
						try {
							if (myLOB.getEnumName().equals(selector.getSelectedLOB())) {
								// myLOB.setVisible(true);
								myLOB.setVisible(true);
								selectedLOBPanel = myLOB;
							} else {
								 myLOB.setVisible(false);
							}
						} catch (Exception e) {
							System.err.println(e.getLocalizedMessage());
						}

					}

				}

			});
		} catch (Exception e) {
			System.err
					.println("Unable to access selector - did you forget to create one in your LOBSelectionPanel (setSelector())?");
		}

		fPanel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (selectedLOBPanel==null) {
					selectedLOBPanel = lobArray.get(0);
				}
				
				selectedLOBPanel.setCurrentSearchValues();
				String urlToOpen = selectedLOBPanel.getURL(config);
				System.err.println("Trying to open " + urlToOpen);
				Utility.OpenLink(urlToOpen, config.getOpenLinksInNewWindow());

			}

		});

	}

	protected void addLOBPanel(LOB lob) {
		if (!lobArray.contains(lob)) {
			lobArray.add(lob);
		}
	}

	protected FocusPanel getSearchFocusPanel() {
		return fPanel;
	}

	protected LineOfBusinessSelector getSelector() {
		return this.selector;
	}

	protected LineOfBusinessConfiguration getConfig() {
		return this.config;
	}

	public abstract void setSelector();
}