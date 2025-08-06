package com.gla;
public class Item {
	private String itemCode;
	private String itemName;
	private int price;
	public Item(String itemCode,String itemName,int price) {
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.price=price;
	}
	public void display() {
		System.out.println("Code Of Item : "+itemCode);
		System.out.println("Name Of Item : "+itemName);
		System.out.println("price Of Item : "+price);
	}
	
	public static void main(String[] args) {
		Item it=new Item("DFGRX2","Shoes",2000);
		it.display();
	}
}
