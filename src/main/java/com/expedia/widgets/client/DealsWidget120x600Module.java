/**
 * 
 */
package com.expedia.widgets.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * @author jackwarner
 *
 */
public class DealsWidget120x600Module extends AbstractGinModule {

	/* (non-Javadoc)
	 * @see com.google.gwt.inject.client.AbstractGinModule#configure()
	 */
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(DealsWidget120x600.class).in(Singleton.class);
	}

}
