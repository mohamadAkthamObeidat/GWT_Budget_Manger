package com.mohammad.obeidat.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {

	// Instance variables.

	private String name;

	private int monthlySalary, balance, income, currentSalary;

	// Array List To Store All User Expense.

	private ArrayList<Expense> userExpenses = new ArrayList<>();

	// Empty Constructor.

	public User() {

	}

	// Constructor
	public User(String name, int monthlySalary, int balance) {

		this.name = name;

		this.monthlySalary = monthlySalary;

		this.currentSalary = monthlySalary;

		this.balance = balance + currentSalary;

	}

	// Getters & Setters.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int salary) {
		this.monthlySalary = salary;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
		this.balance += income;
	}

	public int getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(int currentSalary) {
		this.currentSalary = currentSalary;
	}

	public void autoUpdateBalance() {
		this.balance += this.monthlySalary;
	}

	// Utility Function To Validate Expense Value According To User Month Salary In
	// The Current Date.
	/*
	 * public String validateExpense(int expenseValue) {
	 * 
	 * double partSalary = this.currentSalary / 3; System.out.print("Part Salary: "
	 * + partSalary); System.out.print("Expense Value: " + expenseValue);
	 * System.out.print(partSalary == expenseValue);
	 * 
	 * String userChoice = "Y";
	 * 
	 * // Initialize DateTimeFormatter To Format The Date Depending On Specific //
	 * Pattern. // DateTimeFormatter formattedDate =
	 * DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Get Current Date. //
	 * LocalDateTime currentDate = LocalDateTime.now(); // Format Current Date. //
	 * String date = formattedDate.format(currentDate); // Casting String To
	 * Integer. // int day = Integer.parseInt(date.split("/")[2]);
	 * 
	 * if (day >= 1 && day <= 10) { System.out.println("from first if "); if
	 * (expenseValue >= (partSalary * 2)) { System.out.println(
	 * "You are about to make a high expense value in the current date, the remaining value of your salary will be: "
	 * + (this.currentSalary - expenseValue));
	 * 
	 * System.out.print("Do You Want To Continuo? \t Y/N: "); // userChoice =
	 * input.nextLine(); } } else if (day >= 10 && day <= 20) { if (expenseValue >=
	 * (partSalary * 1)) { System.out.println(
	 * "You are about to make a high expense value in the current date, the remaining value of your salary will be: "
	 * + (this.currentSalary - expenseValue)); }
	 * System.out.print("Do You Want To Continuo? \t Y/N: "); // userChoice =
	 * input.nextLine(); } else { userChoice = "Y"; return "Y"; }
	 * 
	 * return userChoice;
	 * 
	 * }
	 */

	// Utility Function To Add New Expense.

	public void addNewExpense(Expense expense) {

//		if (validateExpense(expense.getValue()).equalsIgnoreCase("Y")) {

			if (this.currentSalary < expense.getValue()) {

				System.out.print("You don't have enough money in your balance.");

			} else {

				if (userExpenses.add(expense)) {

					System.out.println("Expense Added Successfully.");

					updateSalaryAndBalance(expense.getValue());

					System.out.println("Your Current Balance: " + getBalance());

				} else {
					System.out.println("Something Went Wrong, Try Again.");
				}
			}
		/*
		 * } else { System.out.println("No Expenses Added."); }
		 */
	}

	// Utility Function To Update Balance

	public void updateSalaryAndBalance(int newSalaryValue) {

		if (currentSalary >= 0) {
			this.currentSalary -= newSalaryValue;
			this.balance -= newSalaryValue;
		} else {
			this.currentSalary += newSalaryValue;
			this.balance -= newSalaryValue;
		}
	}

	// Utility Function To Display All User Expense.

	public void displayUserExpenses() {

		if (userExpenses.size() == 0) {

			System.out.println("There's No Expenses Yet.\n");

		} else {

			System.out.println(getName() + " Expenses: \n\n");

			for (Expense expense : userExpenses) {

				System.out.print(

						"Expense Name: " + expense.getName() + "\n"

								+ "Value: " + expense.getValue() + "\n"

								+ "Description: " + expense.getDescription() + "\n"

								+ "Category: "
								+ (expense.getCategory() == null ? "Not Specified" : expense.getCategory()) + "\n"

								+ "Added Date: " + expense.getDate().split(" ")[0] + " on "
								+ expense.getDate().split(" ")[1]

				);

				System.out.println();

				System.out.println(
						"_________________________________________________________________________________________");

				System.out.println();

			}

		}

	}

	public void displayUserInfo() {
		System.out.println("Hello " + this.getName() + " Here's Your Information:\n Your Monthly Salary: "
				+ this.getMonthlySalary() + "\nYour Currnet Salary: " + this.getCurrentSalary()
				+ "\n Your Current Balance: " + this.getBalance() + "\n");
	}
}
