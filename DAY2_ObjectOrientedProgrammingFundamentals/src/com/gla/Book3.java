package com.gla;
public class Book3 {
    private String author;
    public String ISBN;
    public String title;

  
    public Book3(String author, String ISBN, String title) {
        this.author = author;
        this.ISBN = ISBN;
        this.title = title;
    }

    
    public String getAuthor() {
        return author;
    }

    
    public void setAuthor(String author) {
        this.author = author;
    }

    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
    }

    
    public static class EBook extends Book3 {
       
        private String fileFormat;

        
        public EBook(String author, String ISBN, String title, String fileFormat) {
            super(author, ISBN, title);
            this.fileFormat = fileFormat;
        }

       
        public String getFileFormat() {
            return fileFormat;
        }

        
        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }

        
        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("File Format: " + fileFormat);
        }
    }

    
    public static void main(String[] args) {
       
        Book3 book = new Book3("George Orwell", "1234567890", "1984");
        book.displayInfo();

        System.out.println();

        
        EBook ebook = new EBook("Jane Austen", "0987654321", "Pride and Prejudice", "PDF");
        ebook.displayInfo();

        
        System.out.println("\nOriginal author of eBook: " + ebook.getAuthor());
        ebook.setAuthor("J. Austen");
        System.out.println("Updated author of eBook: " + ebook.getAuthor());
    }
}