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
	final protected ArrayList<LOB> lobArray;
	private LOB selectedLOBPanel;
	protected LineOfBusinessSelector selector;
	private FocusPanel fPanel = new FocusPanel();

	@Inject
	public LOBSelectionPanel(
			final LineOfBusinessConfiguration config) {
		this.config = config;
		LOBFactory factory = new LOBFactory(this.config);
		this.lobArray = factory.getLOBs();
		selectedLOBPanel = this.lobArray.get(0);
		setSelector();
		try {
			selector.addLOBChangedHandler(new LOBListener() {

				@Override
				public void onChange() {
					Iterator<LOB> lobIter = lobArray.iterator();
					while (lobIter.hasNext()) {
						LOB myLOB = lobIter.next();
						try {
							if (myLOB.getEnumName().equals(
									selector.getSelectedLOB())) {
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
			
					selectedLOBPanel.setCurrentSearchValues();
					String urlToOpen = selectedLOBPanel.getURL(config);
					System.err.println("Trying to open " + urlToOpen);
					Utility.OpenLink(urlToOpen, config.getOpenLinksInNewWindow());
			
				
			}

		});

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


	public ArrayList<LOB> getArrayOfLOBs() {
		return lobArray;
	}

	public abstract void setSelector();
}