package com.gla;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;
    Employee(String name, String department, double salary) {
        this.name = name; this.department = department; this.salary = salary;
    }
    String getDepartment() { return department; }
    double getSalary() { return salary; }
}

public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aman", "IT", 60000),
                new Employee("Neha", "HR", 50000),
                new Employee("Ravi", "IT", 80000),
                new Employee("Simran", "HR", 55000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryByDept);
    }
}

