package com.gla;

public class Employee {
    private String name;
    private String id;
    private double salary;

   
     
    public Employee(String name, String id, double salary) {
        this.name = name;  
        this.id = id;
        this.salary = salary;
    }

   
    public void displayDetails() {
        System.out.println("--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println(salary); 
    }



    
     public static void main(String[] args) {
        Employee employee1 = new Employee("Alice Wonderland", "E001", 75000);
        System.out.println("Displaying Employee 1 details:");
        employee1.displayDetails();
        System.out.println("\n");
        Employee employee2 = new Employee("Bob The Builder", "E002", 60000);
        System.out.println("Displaying Employee 2 details:");
        employee2.displayDetails();
    }
}
