package com.gla;
public class Student {
   
    public int rollNumber;

    protected String name;
    
    private double CGPA;

    
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

   
    public double getCGPA() {
        return CGPA;
    }

   
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }


    public void accessAndModifyCGPA(double newCGPA) {
        System.out.println("Current CGPA: " + CGPA);
        this.CGPA = newCGPA;
        System.out.println("Updated CGPA: " + CGPA);
    }
    
}


