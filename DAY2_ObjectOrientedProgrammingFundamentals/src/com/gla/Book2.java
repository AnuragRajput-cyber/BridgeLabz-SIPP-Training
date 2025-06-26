package com.gla;
public class Book2 {
    private String title;
    private String author;
    private double price;
    private boolean availability;

  
    public Book2(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    public boolean borrowBook() {
        if (availability) {
            availability = false;
            return true; 
        } else {
            return false; 
        }
    }


    public static void main(String[] args) {
        Book2 myBook = new Book2("Mocktest", "Raghav Panwar", 45.99, true);
        System.out.println("Title: " + myBook.getTitle());
        System.out.println("Author: " + myBook.getAuthor());
        System.out.println("Price: " + myBook.getPrice());
        System.out.println("Available: " + myBook.isAvailable());

       
        if (myBook.borrowBook()) {
            System.out.println("Successfully borrowed the book.");
        } else {
            System.out.println("The book is already borrowed.");
        }

  
        System.out.println("Available after borrowing: " + myBook.isAvailable());
    }
}