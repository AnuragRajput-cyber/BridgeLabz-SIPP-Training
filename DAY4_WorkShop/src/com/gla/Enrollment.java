package com.gla;
class Enrollment {
    private Student student;
    private Course course;
    private Double grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = null;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }
    public void displayInfo() {
    	System.out.println("student Id: "+student.getStudentId()+", Student Name: "+student.getName()+", course Id: "+course.courseId()+", Course Name: "+course.getCourseName()+", Grades: "+grade);
    }
}