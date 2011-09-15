package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SuggestBox;

abstract public class ExpediaSuggestion extends Composite {
	protected TypeAheadOracle oracle = new TypeAheadOracle();
	protected SuggestBox destination = new SuggestBox(oracle);
	public abstract String getValue();
	final public void setLimit(int suggestionBoxLimit) {
		destination.setLimit(suggestionBoxLimit);
	
	}
}
