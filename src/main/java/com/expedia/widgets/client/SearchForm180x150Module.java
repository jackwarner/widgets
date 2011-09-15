package com.expedia.widgets.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class SearchForm180x150Module extends AbstractGinModule {
 protected void configure() {
	 bind(SearchFormWidget180x150.class).in(Singleton.class);
 }
}
