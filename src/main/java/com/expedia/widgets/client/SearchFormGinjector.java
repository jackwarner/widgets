package com.expedia.widgets.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(SearchForm180x150Module.class)
interface SearchFormGinjector extends Ginjector {
	
	SearchFormWidget180x150 getSearchForm300x250();
}

