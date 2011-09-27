package com.expedia.widgets.client;

import java.util.Iterator;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.inject.Inject;

public class LOBSelectionPanel300x250 extends LOBSelectionPanel {

	@Inject
	public LOBSelectionPanel300x250(LineOfBusinessConfiguration config) {
		super(config);

		AbsolutePanel panel = new AbsolutePanel();
		try {
			panel.add(getSelector(), 165, 0);
		} catch (Exception e) {
			System.err.println("You must implement a Selector for this size!");
		}
		panel.setPixelSize(260, 220);

		if (config.getLinesOfBusiness().size() <= 0) {
			System.err.println("Cant build a search form with no LOBs!");
		} else {

			Iterator<LOB> lobIter = getArrayOfLOBs().iterator();
			while (lobIter.hasNext()) {
				try {
					LOB lob = lobIter.next();

					if (!config.getDefaultLOB().equals(lob.getEnumName())) {
						lob.setVisible(false);
					}
					//panel.insert(lob, layout.getLOBLeft(), layout.getLOBTop(),
						//	0);
				} catch (Exception e) {
					System.err
							.println("Check that you are instantiating the right size of LOBSelection Panel for your Widget size.");
				}
			}
		}

		SearchFormSearchButton searchButton = new SearchFormSearchButton(
				config,92,33);

		HorizontalPanel searchPanel = new HorizontalPanel();
		searchPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		searchPanel.setWidth("258px");

		getSearchFocusPanel().add(searchButton);
		searchPanel.add(getSearchFocusPanel());
		panel.add(searchPanel, 0, 178);
		initWidget(panel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.expedia.streetviewwidget.client.LOBSelectionPanel#setSelector()
	 */
	@Override
	public void setSelector() {
		selector = new SearchFormLOBSelectorButton120x600(
				 getConfig());
	}

}
