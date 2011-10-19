package com.expedia.widgets.client;

public class WidgetFactoryException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Unable to create Widget from Factory.  Have you implemented all required skins, views, and layouts for this size?";

	@Override
	public String getLocalizedMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
