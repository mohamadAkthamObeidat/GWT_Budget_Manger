package com.mohammad.obeidat.client;

import java.util.EnumSet;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Budget_Manager implements EntryPoint {

	public User user;
	public String expenseCategoryValue;

	public void onModuleLoad() {

		HorizontalPanel mainPanel = new HorizontalPanel();
		mainPanel.setSpacing(20);

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
		hPanel_Two.add(yourSalary);
		hPanel_Two.add(userSalary);

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

		// Add Button.
		Button addButton = new Button("Add");
		addButton.setSize("25%", "5%");

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

		vPanel.add(hPanel_One);
		vPanel.add(hPanel_Two);
		vPanel.add(hPanel_Three);
		vPanel.add(addButton);

		// Add Expenses Panel
		// *******************************************************************************************

		final VerticalPanel expensesPanel = new VerticalPanel();
		expensesPanel.setSpacing(10);

		// Expense Name.
		Label expenseName_LBL = new Label("Expense Name: ");

		final TextBox expenseName_TB = new TextBox();
		expenseName_TB.ensureDebugId("cwBasicText-textbox");

		// Expense Value.
		Label expenseValue_LBL = new Label("Expense Value: ");

		final TextBox expenseValue_TB = new TextBox();
		expenseValue_TB.ensureDebugId("cwBasicText-textbox");

		// Expense Category.
		Label expenseCategory_LBL = new Label("Expense Category: ");
//
//		final TextBox expenseCategory_TB = new TextBox();
//		expenseCategory_TB.ensureDebugId("cwBasicText-textbox");

		// Add a drop box with the list types
		final ListBox expenseCategory_MEN = new ListBox();
		for (CATEGORIES category : CATEGORIES.values()) {
			expenseCategory_MEN.addItem(category.name());
		}

		VerticalPanel dropBoxPanel = new VerticalPanel();
		dropBoxPanel.setSpacing(4);
		dropBoxPanel.add(expenseCategory_MEN);

		// Expense Description.
		Label expenseDescription_LBL = new Label("Expense Description: ");

		final TextBox expenseDescription_TB = new TextBox();
		expenseDescription_TB.ensureDebugId("cwBasicText-textbox");

		// Add Expense Button.
		Button addExpense = new Button("Add Expense");
		addButton.setSize("25%", "5%");

		expensesPanel.add(expenseName_LBL);
		expensesPanel.add(expenseName_TB);
		expensesPanel.add(expenseValue_LBL);
		expensesPanel.add(expenseValue_TB);
		expensesPanel.add(expenseCategory_LBL);
		expensesPanel.add(expenseCategory_MEN);
		expensesPanel.add(expenseDescription_LBL);
		expensesPanel.add(expenseDescription_TB);
		expensesPanel.add(addExpense);

		// End Add Expenses Panel
		// ***************************************************************************************

		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String name = userName.getText();
				int salary = Integer.parseInt(userSalary.getText());
				int balance = Integer.parseInt(userBalance.getText());

				user = new User(name, salary, balance);

				helloMessage.setText("Hello " + user.getName() + " here's your Information: ");
				monthlySalary.setText("Monthly Salary: " + user.getMonthlySalary());
				currentSalary.setText("Current Salary: " + user.getCurrentSalary());
				currentBalance.setText("Current Balance: " + user.getBalance());

				RootPanel.get().add(expensesPanel);
			}
		});

		expenseCategory_MEN.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				expenseCategoryValue = expenseCategory_MEN.getSelectedItemText();
			}
		});

		addExpense.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String expenseName = expenseName_TB.getText();
				int expenseValue = Integer.parseInt(expenseValue_TB.getText());
				String expenseCategory = expenseCategoryValue;
				String expenseDiscription = expenseDescription_TB.getText();

				user.addNewExpense(new Expense(expenseName, expenseValue, expenseDiscription, expenseCategory));
				
			}
		});
		mainPanel.add(vPanel);
		mainPanel.add(vPanel_Two);

		// Display The Panel On HTML Page.
		RootPanel.get().add(mainPanel);
	}
}
