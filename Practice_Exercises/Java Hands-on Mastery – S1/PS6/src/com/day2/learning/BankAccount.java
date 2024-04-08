package com.day2.learning;

import java.util.Scanner;

// Custom exception for negative amount
class NegativeAmountException extends Exception {
	public NegativeAmountException(String message) {
		super(message);
	}
}


// Custom exception for low balance
class LowBalanceException extends Exception {
	public LowBalanceException(String message) {
		super(message);
	}
}


// BankAccount class
public class BankAccount {
	// Fields
	private int accNo;
	private String custName;
	private String accType;
	private float balance;

	// Constructor
	public BankAccount(int accNo, String custName, String accType, float initialBalance)
			throws NegativeAmountException, LowBalanceException {
		this.accNo = accNo;
		this.custName = custName;
		this.accType = accType;

		// Check if balance is negative
		if (initialBalance < 0) {
			throw new NegativeAmountException("Negative Amount");
		}

		// Check for minimum balance based on account type
		if (accType.equals("savings") && initialBalance < 1000) {
			throw new LowBalanceException("Low Balance");
		} else if (accType.equals("current") && initialBalance < 5000) {
			throw new LowBalanceException("Low Balance");
		}

		this.balance = initialBalance;
	}

	// Method to deposit amount
	public void deposit(float amt) throws NegativeAmountException {
		// Check if amount is negative
		if (amt < 0) {
			throw new NegativeAmountException("Negative Amount");
		}
		// Deposit amount
		this.balance += amt;
	}

	// Method to get balance
	public float getBalance() throws LowBalanceException {
		// Check if balance is below minimum required balance
		if ((accType.equals("savings") && balance < 1000) || (accType.equals("current") && balance < 5000)) {
			throw new LowBalanceException("Low balance.");
		}
		return balance;
	}

	// Main method for testing
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	    try {
	        // Get input for account details
	        System.out.println("Enter account number:");
	        int accNo = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        System.out.println("Enter customer name:");
	        String custName = scanner.nextLine();

	        System.out.println("Enter account type (savings/current):");
	        String accType = scanner.nextLine();

	        System.out.println("Enter initial balance:");
	        float initialBalance = scanner.nextFloat();

	        // Creating a new BankAccount object
	        BankAccount account = new BankAccount(accNo, custName, accType, initialBalance);

	        // Get input for deposit amount
	        System.out.println("Enter amount to deposit:");
	        float depositAmount = scanner.nextFloat();

	        // Deposit amount
	        account.deposit(depositAmount);

	        // Get and print balance
	        System.out.println("Current Balance: " + account.getBalance());
	    } catch (NegativeAmountException | LowBalanceException e) {
	        // Catching and printing exceptions
	        e.printStackTrace();
	    } 
}
}
