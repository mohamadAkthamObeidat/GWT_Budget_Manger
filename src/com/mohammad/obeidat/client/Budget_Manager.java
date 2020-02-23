package com.mohammad.obeidat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Budget_Manager implements EntryPoint {

	public void onModuleLoad() {

		// Vertical Layout To Contain Other Components.
		VerticalPanel vPanel = new VerticalPanel();
		// Add Some Margins Between Components.
		vPanel.setSpacing(5);

		// ***************************************************************************************************************************

		// Horizontal Panel One.
		HorizontalPanel hPanel_One = new HorizontalPanel();
		hPanel_One.setSpacing(5);

		// Create Label For UserName.
		Label yourName = new Label("Your Name: ");

		// Create New TextBox For UserName.
		final TextBox userName = new TextBox();
		userName.ensureDebugId("cwBasicText-textbox");

		// Add Components To Panel.
		hPanel_One.add(yourName);
		hPanel_One.add(userName);

		// ***************************************************************************************************************************

		// Horizontal Panel Two.
		HorizontalPanel hPanel_Two = new HorizontalPanel();
		hPanel_Two.setSpacing(5);

		// Create Label For Salary.
		Label yourSalary = new Label("Your Salary: ");

		// Create New TextBox For Salary.
		final TextBox userSalary = new TextBox();
		userSalary.ensureDebugId("cwBasicText-textbox");

		// Add Components To Panel.
		hPanel_One.add(yourSalary);
		hPanel_One.add(userSalary);

		// ***************************************************************************************************************************

		// Horizontal Panel Three.
		HorizontalPanel hPanel_Three = new HorizontalPanel();
		hPanel_Three.setSpacing(5);

		// Create Label For Salary.
		Label yourBalance = new Label("Your Balance: ");

		// Create New TextBox For Salary.
		final TextBox userBalance = new TextBox();
		userBalance.ensureDebugId("cwBasicText-textbox");

		// Add Components To Panel.
		hPanel_Three.add(yourBalance);
		hPanel_Three.add(userBalance);
		// ***************************************************************************************************************************

		VerticalPanel vPanel_Two = new VerticalPanel();
		
		final Label helloMessage = new Label();
		final Label monthlySalary = new Label();
		final Label currentSalary = new Label();
		final Label currentBalance = new Label();

		vPanel_Two.add(helloMessage);
		vPanel_Two.add(monthlySalary);
		vPanel_Two.add(currentSalary);
		vPanel_Two.add(currentBalance);

		HorizontalPanel hPanel_Four = new HorizontalPanel();
		hPanel_Four.add(vPanel_Two);
		
		// Add Button.
		Button addButton = new Button("Add");
		addButton.setSize("25%", "5%");

		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = userName.getText();
				int salary = Integer.parseInt(userSalary.getText());
				int balance = Integer.parseInt(userBalance.getText());

				User user = new User(name, salary, balance);

				helloMessage.setText("Hello " + user.getName() + " here's your Information: ");
				monthlySalary.setText("Monthly Salary: " + user.getMonthlySalary());
				currentSalary.setText("Current Salary: " + user.getCurrentSalary());
				currentBalance.setText("Current Balance: " + user.getBalance());
			}
		});

		vPanel.add(hPanel_One);
		vPanel.add(hPanel_Two);
		vPanel.add(hPanel_Three);
		vPanel.add(addButton);

		// Display The Panel On HTML Page.
		RootPanel.get().add(vPanel);
	}
}
