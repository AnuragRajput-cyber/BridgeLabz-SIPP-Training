package com.gla;

public class UniversityCourseEnrollmentSystem {
	public static void main(String[] args) {
		Undergraduate ug=new Undergraduate("Omkeshwar",101);
		Course c1=new Course("Hinglish","BMAS0201");
		Faculty f1=new Faculty("Raghav dubay",11);
		Enrollment e1=new Enrollment(ug,c1);
		f1.assignGrades(e1,5.0);
		e1.displayInfo();
		System.out.println("After Updating Grades: ");
		f1.assignGrades(e1, 8.0);
		e1.displayInfo();
		Undergraduate pg=new Undergraduate("Raghav",102);
		Course c2=new Course("english","BMAS0202");
		Faculty f2=new Faculty("Anurag dubay",12);
		Enrollment e2=new Enrollment(pg,c2);
		f1.assignGrades(e2,6.0);
		e2.displayInfo();
	}
}
