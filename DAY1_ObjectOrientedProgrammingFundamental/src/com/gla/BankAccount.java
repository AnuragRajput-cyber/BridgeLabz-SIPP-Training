package com.gla;

public class BankAccount {
	private String accountHolder;
	private long accountNumber;
	private double balance;
	public BankAccount(String accountHolder,long accountNumber,double balance) {
		this.accountHolder=accountHolder;
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	public void accountHolderDetails() {
		System.out.println("Account Holder Name: "+accountHolder);
		System.out.println("Account Number: "+accountNumber);
	}
	public void depositeMoney(double deposite) {
		balance+=deposite;
		System.out.println("Current balance after deposite "+balance);
	}
	public void withdrawMoney(double withdraw) {
		if(withdraw<=balance) {
		balance-=withdraw;
		}
		System.out.println("Current balance after withdraw "+balance);
	}
	public void currentBalance() {
		System.out.println("Current Balance of "+accountNumber +" is "+balance);
	}
	public static void main(String[] args) {
		BankAccount  ba=new BankAccount("Anurag",11111111,2548.25);
		ba.accountHolderDetails();
		ba.currentBalance();
		ba.depositeMoney(1000.00);
		ba.withdrawMoney(500.00);
		ba.currentBalance();
	}
}
