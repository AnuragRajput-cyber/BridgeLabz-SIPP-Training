package com.gla;
public class Employee {
    public static String companyName;
    private static int totalEmployees = 0;

    private int id;
    private String name;
    private String designation;

    static {
        companyName = "GLA";
    }

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
        this.id = ++totalEmployees;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public static void main(String[] args) {
        Employee.companyName = "Tech Solutions";

        Employee emp1 = new Employee("Alice", "Developer");
        Employee emp2 = new Employee("Bob", "Manager");

        Employee.displayTotalEmployees();

        System.out.println("Employee 1 ID: " + emp1.getId() + ", Name: " + emp1.getName() + ", Designation: " + emp1.getDesignation());
        System.out.println("Employee 2 ID: " + emp2.getId() + ", Name: " + emp2.getName() + ", Designation: " + emp2.getDesignation());
    }
}