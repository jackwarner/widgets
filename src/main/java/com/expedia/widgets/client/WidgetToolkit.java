/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.expedia.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The entry point class which performs the initial loading of the WidgetToolkit
 * application.
 */
public class WidgetToolkit implements EntryPoint {

	final SearchFormGinjector injector = GWT.create(SearchFormGinjector.class);

	/**
	 * This method sets up the top-level services used by the application.
	 */
	public void onModuleLoad() {

		/*String sizeString = Window.Location.getParameter("size");

		if (Window.Location.getParameter("widgetname").equals("searchform")) {

			if (sizeString.equals("180x150"))
				GWT.runAsync(WidgetToolkitLoad.class, new RunAsyncCallback() {

					@Override
					public void onFailure(Throwable reason) {
						System.err
								.println("Unable to load code for Hotel Amenity Widget.");
					}

					@Override
					public void onSuccess() {

						RootPanel.get().add(new Load180x150(), 0, 0);

						GWT.runAsync(WidgetToolkitContent.class,
								new RunAsyncCallback() {

									@Override
									public void onFailure(Throwable reason) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onSuccess() {
										// TODO Auto-generated method stub

										SearchFormWidget180x150 test = injector
												.getSearchForm180x150();
										RootPanel.get().add(test, 0, 0);
									}

								});
					}

				});
			else if (sizeString.equals("300x250")) {
				SearchFormWidget300x250 test = injector.getSearchForm300x250();
				System.out.println("Added");
				RootPanel.get().add(test, 0, 0);
			}
		}
		else {*/
		GWT.runAsync(WidgetToolkitLoad.class, new RunAsyncCallback() {
			

			@Override
			public void onFailure(Throwable reason) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess() {
				GWT.runAsync(WidgetToolkitContent.class,
						new RunAsyncCallback() {

							@Override
							public void onFailure(Throwable reason) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess() {
								// TODO Auto-generated method stub

								// TODO Auto-generated method stub
								DealsWidget120x600 test1 = injector.getDealsWidget120x600();
								RootPanel.get().add(test1, 0, 0);
							}

						});
				
			}
			
		});
		//}

	}
}
