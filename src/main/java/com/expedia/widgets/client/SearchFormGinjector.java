package com.expedia.widgets.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({DealsWidget120x600Module.class, SearchForm300x250Module.class})
interface SearchFormGinjector extends Ginjector {
	
	SearchFormWidget300x250 getSearchForm300x250();
	DealsWidget120x600 getDealsWidget120x600();

}

