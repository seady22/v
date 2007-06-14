package com.itmill.toolkit.terminal.gwt.client.ui;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.itmill.toolkit.terminal.gwt.client.Client;
import com.itmill.toolkit.terminal.gwt.client.Paintable;
import com.itmill.toolkit.terminal.gwt.client.UIDL;

public class TkCheckBox extends com.google.gwt.user.client.ui.CheckBox
		implements Paintable {

	String id;

	boolean immediate;

	Client client;

	public TkCheckBox() {
		addClickListener(new ClickListener() {

			public void onClick(Widget sender) {
				if (id == null || client == null)
					return;
				client.updateVariable(id, "state", isChecked(), immediate);
			}

		});
	}

	public void updateFromUIDL(UIDL uidl, Client client) {
		
		// Ensure correct implementation
		if (client.replaceComponentWithCorrectImplementation(this, uidl))
			return;

		// Save details
		this.client = client;
		id = uidl.getId();

		// Set text
		setText(uidl.getStringAttribute("caption"));
		setChecked(uidl.getBooleanVariable("state"));
		immediate = uidl.getBooleanAttribute("immediate");
	}

}
