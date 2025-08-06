package com.gla;
class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Customer c) {
        System.out.println("Account opened for " + c.getName() + " at " + name);
    }
}

class Customer {
    private String name;
    private Bank bank;

    public Customer(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Bank getBank() {
    	return this.bank;
    }

    public String getName() {
        return name;
    }

    public void viewBalance() {
        System.out.println(name + "'s balance is $1000");
    }

    public static void main(String[] args) {
        Bank bank = new Bank("City Bank");
        Customer cust = new Customer("Alice");
        cust.setBank(bank);
        bank.openAccount(cust);
        cust.viewBalance();
    }
}
