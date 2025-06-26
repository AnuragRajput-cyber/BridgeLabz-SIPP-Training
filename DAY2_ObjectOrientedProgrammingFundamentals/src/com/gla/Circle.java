package com.gla;
import java.util.*;
public class Circle {
	private double radius;
	public Circle() {
		this.radius=radius;
	}
	public  Circle(double rad) {
		this.radius=rad;
	}
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		double rad=sc.nextDouble();		
		Circle cl1 = new Circle(rad);
		Circle cl2 = new Circle(6.2);
		System.out.println("radius of Cl1:"+cl1.radius);
		System.out.println("radius of Cl2:"+cl2.radius);
	
	}
}
