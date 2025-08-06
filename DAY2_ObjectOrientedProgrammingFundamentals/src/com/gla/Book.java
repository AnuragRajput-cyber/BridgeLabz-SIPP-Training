package com.gla;

public class Book {
	
	private String title;
	private String author;
	private int price;
	
	public Book(String title,String author,int price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}
	public Book() {
		this.title="Unknown";
		this.author="Unknown";
		this.price=0;
	}
	public void displayInfo() {
		System.out.println("Title of the Book: "+title+"------------->");
		System.out.println("Athor:"+author);
		System.out.println("Price:"+price);
	}
	
	public static void main(String[] args) {
		Book Book  = new Book();
		Book Book2  = new Book("Godan Gaban","PremChandra",5846);
		Book.displayInfo();
		Book2.displayInfo();
	}

}
