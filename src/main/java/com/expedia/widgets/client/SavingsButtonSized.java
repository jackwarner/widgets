package com.expedia.widgets.client;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class SavingsButtonSized extends
		SavingsButtonMouseoverToggleTextAndFlashlightAnimated {

	public SavingsButtonSized(int savingsPercentage, int width, int height,
			DealsWidgetSkin skin) {
		super(savingsPercentage, skin);
		try {

			setSize(width, height);
			getPanel().add(getBookOver(), 0, 0);
			getPanel().add(getBookOut(), 0, 0);

			HorizontalPanel bookPanel = new HorizontalPanel();
			bookPanel
					.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			bookPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			bookPanel.setPixelSize(width, height);

			HorizontalPanel bookPanel2 = new HorizontalPanel();
			bookPanel2
					.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			bookPanel2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			bookPanel2.setPixelSize(width, height);

			bookPanel.add(getSavings());
			bookPanel2.add(getBookNow());
			getPanel().add(bookPanel, 0, 0);
			getPanel().add(bookPanel2, 0, 0);
			// getPanel().add(getFlashlight(),(getFlashlight().getWidth()*-1),0);

		} catch (Exception e) {
			System.err.println("Unable to generate button image.");
		}
	}

}
