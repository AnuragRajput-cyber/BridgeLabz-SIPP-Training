package com.gla;

class Student {
    private String name;
    private int student_Id;
    private Double gpa;
    private String electivePreference;

    public Student(String name, int studentId) {
        this.name = name;
        this.student_Id = studentId;
        this.gpa = 0.0;
    }

    public Student(String name, int studentId, String electivePreference) {
        this(name, studentId);
        this.electivePreference = electivePreference;
    }

 
    public void calculateGPA(double tPoints, int tCourses) {
        if (tCourses == 0) {
            this.gpa = 0.0;
        } else {
            this.gpa = tPoints / tCourses;
        }
    }

    public double addingGPA(double addGPA) {
        return this.gpa + addGPA;
    }

  
    public int comparingGpa(Student other) {
        return this.gpa.compareTo(other.gpa);
    }

    public double getGpa() {
        return this.gpa;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentId() {
        return this.student_Id;
    }
}
