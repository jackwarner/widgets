package com.expedia.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class SearchFormWidget300x250 extends SearchFormWithLinesOfBusiness
implements SearchFormContract {
	
	final protected SearchFormResources300x250 resources = GWT
			.create(SearchFormResources300x250.class); 

	public SearchFormWidget300x250() {
		
		AbsolutePanel panel = new AbsolutePanel();
		StyleInjector.inject(resources.myCss300x250().getText());
		panel.setPixelSize(300,250);
		panel.add(new Image(resources.canvas300x250().getSafeUri()), 0, 0);
		panel.add(getLogo(), 20, 20);
		lobsPanel = new LOBSelectionPanel300x250(getConfig());
		panel.add(lobsPanel, 20, 20);

		initWidget(panel);
	}

	public Widget getLogo() {
		HorizontalPanel logoPanel = new HorizontalPanel();
		logoPanel.setPixelSize(135, 37);
		logoPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		logoPanel.add(new Image(resources.expediaLogoHorizontal135x37().getSafeUri()));
		return logoPanel;
	}
}
