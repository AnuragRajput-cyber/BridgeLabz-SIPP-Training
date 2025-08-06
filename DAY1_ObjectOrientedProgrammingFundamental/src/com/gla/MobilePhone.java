package com.gla;

public class MobilePhone {
	private String brand;
	private String model;
	private int price;
	
	public MobilePhone(String brand,String model,int price) {
		this.brand=brand;
		this.model=model;
		this.price=price;
	}
	public void display() {
		System.out.println("-Mobile Details-");
		System.out.println("Mobile's brand "+brand);
		System.out.println("Mobile's model "+ model);
		System.out.println("Mobile's price "+ price);
		System.out.println("----------------------");
		
	}
	public static void main(String[] args) {
		MobilePhone mp1 = new MobilePhone("Samsung","s22",124000);
		mp1.display();
		MobilePhone mp2 = new MobilePhone("Redmi","Note 10 Pro MAX",19000);
		mp2.display();
		
	}
	
}
