package com.gla;

public class BankAccount {
	public int customerId=12;
	void display() {
		System.out.println(customerId);
	}
	public static void main(String[] args) {
		BankAccount bk = new BankAccount();
		bk.display();
	}
}

