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
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The entry point class which performs the initial loading of the WidgetToolkit
 * application.
 */
public class WidgetToolkit implements EntryPoint {
  

  /**
   * This method sets up the top-level services used by the application.
   */
  public void onModuleLoad() {
	  final SearchFormGinjector injector = GWT.create(SearchFormGinjector.class);
	  SearchFormWidget180x150 test = injector.getSearchForm300x250();
	 // test.setPixelSize(180, 150);
	  RootPanel.get().setPixelSize(180, 150);
	  RootPanel.get().add(test);
	
  }
}
