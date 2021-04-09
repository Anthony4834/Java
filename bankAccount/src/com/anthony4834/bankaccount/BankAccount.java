package com.anthony4834.bankaccount;

public class BankAccount {
	private static int accountsCreated = 0;
	private static double totalBalance = 0;
	
	private String accountNum;
	private double checkingBalance;
	private double savingsBalance;
	
	public BankAccount() {
		setAccountNum(randNum("checking"));
		setAccountsCreated(getAccountsCreated() + 1);
		
	}
	
	private String randNum(String type) {
		String output = type == "checking" ? "1" : "2";
		for(int i = 0; i < 9; i++) {
			output += String.valueOf((int) Math.floor(Math.random() * 10));
		}
		return output;
	}
	
	public String makeDeposit(double amount, String account) {
		if(amount <= 0 ) {return "Please input number greater than 0";}
		if(account == "checking") {
			setCheckingBalance(getCheckingBalance() + amount);
		} else {
			setSavingsBalance(getSavingsBalance() + amount);
		}
		setTotalBalance(getAccountsCreated() + amount);
		return String.format("Thank you for your deposit. New balace: %s", amount);
	}
	public String makeWithdrawal(double amount, String account) {
		if(amount <= 0 ) {return "Please input number greater than 0";}
		if(account == "checking") {
			if(getCheckingBalance() >= amount) {
				setCheckingBalance(getCheckingBalance() - amount);
				setTotalBalance(getTotalBalance() - amount);
				return String.format("%s successfully withdrawn from %s", amount, account);
			} else {
				return "Insufficient funds";
			}
		} else {
			if(getSavingsBalance() >= amount) {
				setSavingsBalance(getSavingsBalance() - amount);
				setTotalBalance(getTotalBalance() - amount);
				return String.format("%s successfully withdrawn", amount);
			} else {
				return "Insufficient funds";
			}
		}
	}

	public static int getAccountsCreated() {
		return accountsCreated;
	}

	public static void setAccountsCreated(int accountsCreated) {
		BankAccount.accountsCreated = accountsCreated;
	}

	public static double getTotalBalance() {
		return totalBalance;
	}

	private static void setTotalBalance(double totalBalance) {
		BankAccount.totalBalance = totalBalance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	private void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	private void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
}
