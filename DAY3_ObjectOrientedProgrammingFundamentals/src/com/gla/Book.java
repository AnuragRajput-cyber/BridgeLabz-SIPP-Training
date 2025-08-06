package com.gla;
public class Book {
    private static String libraryName;
    private String title;
    private String author;
    private final String isbn;

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public static void main(String[] args) {
        libraryName = "City Library";
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book.displayLibraryName();
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
        System.out.println("ISBN: " + book1.getIsbn());
    }
}