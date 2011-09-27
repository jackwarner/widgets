package com.expedia.widgets.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class SearchForm300x250Module extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(SearchFormWidget300x250.class).in(Singleton.class);
		bind(LOB_Hotel.class).to(HotelSearchPanel300x250.class).in(Singleton.class);
		
	}
}
