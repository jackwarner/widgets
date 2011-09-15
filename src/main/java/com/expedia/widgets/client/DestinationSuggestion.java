package com.expedia.widgets.client;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

public class DestinationSuggestion implements IsSerializable, Suggestion {
	private String s;

	// Required for IsSerializable to work
	public DestinationSuggestion() {
	}

	// Convenience method for creation of a suggestion
	public DestinationSuggestion(String s) {
		this.s = s;
	}

	@Override
	public String getDisplayString() {
		return s;
	}

	@Override
	public String getReplacementString() {
		return s;
	}
}
