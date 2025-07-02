package com.gla;
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Year: " + publicationYear);
    }
}

class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + authorName + ", Bio: " + bio);
    }
}

public class LibraryTest {
    public static void main(String[] args) {
        Author a = new Author("Effective Java", 2018, "Joshua Bloch", "Expert in Java programming.");
        a.displayInfo();
    }
}
