package com.gla;

public class Course {
	private String courseName;
	private String courseId;
	Course(String courseName,String courseId){
		this.courseName=courseName;
		this.courseId=courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public String courseId() {
		return courseId;
	}
}
