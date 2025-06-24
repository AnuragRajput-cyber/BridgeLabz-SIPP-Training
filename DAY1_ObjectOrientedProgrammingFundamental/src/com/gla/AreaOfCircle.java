package com.gla;
import java.util.Scanner;

public class AreaOfCircle{
	private double radius;
	 public AreaOfCircle(double radius) {
		this.radius = radius;
	}
	 public double area() {
		 return Math.PI*radius*radius;
	 }
	 public void display() {
		 System.out.println("Area of Circle "+ area());
	 }
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 double rad=sc.nextDouble();
		 AreaOfCircle aoc = new AreaOfCircle(rad);
		 aoc.display();
	 }
}