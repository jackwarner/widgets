package com.expedia.widgets.client;

public class WidgetNameException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "No Widget Name specified.  A widget name is required to build an Expedia widget.";

	@Override
	public String getLocalizedMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
