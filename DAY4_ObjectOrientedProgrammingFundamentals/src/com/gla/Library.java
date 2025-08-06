package com.gla;
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getInfo() {
        return title + " by " + author;
    }
}

class Library {
    private Book book1;
    private Book book2;

    public Library(Book book1, Book book2) {
        this.book1 = book1;
        this.book2 = book2;
    }

    public void showBooks() {
        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());
    }

    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("Animal Farm", "George Orwell");
        Library lib = new Library(b1, b2);
        lib.showBooks();
    }
}
