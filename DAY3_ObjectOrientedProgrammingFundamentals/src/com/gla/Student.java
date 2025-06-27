package com.gla;
public class Student {
    private final int rollNumber;
    private String name;
    private String grade;
    private static String universityName;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public static void setUniversityName(String universityName) {
        Student.universityName = universityName;
    }

    public static void displayTotalStudents(int totalStudents) {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public static String getUniversityName() {
        return universityName;
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
    }



    public static void main(String[] args) {
        Student.setUniversityName("GLA University");
        Student student1 = new Student("Raghav", 101, "A");
        Student student2 = new Student("Omkar", 102, "B");
        student1.displayStudentInfo();
        System.out.println();
        student2.displayStudentInfo();
        Student.displayTotalStudents(2);
    }
}
