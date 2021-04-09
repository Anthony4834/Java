package com.anthony4834.bankaccount;

public class Run {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		System.out.println(account1.makeDeposit(999.99, "checking"));
		System.out.println(account1.getCheckingBalance());
		System.out.println(account1.makeWithdrawal(1000, "checking"));
		
	}
	
}
