package com.gla;

public class Faculty implements Grades{
	private String facultyName;
	private int facultyId;
	Faculty(String facultyName,int facultyId){
		this.facultyName=facultyName;
		this.facultyId=facultyId;
	}
	@Override
	public void assignGrades(Enrollment enrollment, double grade) {
			enrollment.setGrade(grade);
	}
	
}
