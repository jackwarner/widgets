package com.expedia.widgets.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({SearchForm180x150Module.class, DealsWidget250x250Module.class, SearchForm300x250Module.class})
interface SearchFormGinjector extends Ginjector {
	
	SearchFormWidget180x150 getSearchForm180x150();
	SearchFormWidget300x250 getSearchForm300x250();
	DealsWidget250x250 getDealsWidget250x250();

}

