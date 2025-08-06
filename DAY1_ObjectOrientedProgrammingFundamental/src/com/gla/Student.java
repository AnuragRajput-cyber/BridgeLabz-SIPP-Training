package com.gla;

public class Student {
	private String name;
	private int rollNumber;
	private double marks;
	private char result;
	public Student(String name,int rollNumber,double marks) {
		this.name=name;
		this.rollNumber=rollNumber;
		this.marks=marks;
	}
	public char grades(double marks) {
		if(marks>=9.00) {result='O';}
		if(marks>=8.00) {result='A';}
		if(marks>=7.00) {result='B';}
		if(marks>=6.00) {result='C';}
		return result;
	}
	public void display() {
		System.out.println("Student Details---");
		System.out.println("Student's name:--- "+name);
		System.out.println(name+"'s RollNumber:--- "+rollNumber);
		System.out.println(name+"'s grade:--- "+grades(marks));
	}
	
	public static void main(String[] args) {
		Student st = new Student("raghav Awasthi",14,6.25);
		st.display();
	}
	
}
