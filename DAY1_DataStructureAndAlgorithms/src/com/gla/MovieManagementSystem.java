package com.gla;

class MovieNode {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }
}

public class MovieManagementSystem {

    public MovieNode addAtBeginning(MovieNode head, MovieNode newNode) {
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public MovieNode addAtEnd(MovieNode head, MovieNode newNode) {
        if (head == null) {
            return newNode;
        }
        MovieNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public MovieNode addAtIndex(MovieNode head, int index, MovieNode newNode) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        if (index == 0) {
            return addAtBeginning(head, newNode);
        }
        MovieNode curr = head;
        int count = 0;
        while (curr != null && count < index - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
    }

    public static void displayMovie(MovieNode head) {
        if (head == null) {
            System.out.println("Movies list is empty.");
            return;
        }
        MovieNode curr = head;
        while (curr != null) {
            System.out.println("Movie Title: " + curr.movieTitle +
                    ", Director: " + curr.director +
                    ", Year Of Release: " + curr.yearOfRelease +
                    ", Rating: " + curr.rating);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem ms = new MovieManagementSystem();
        MovieNode head = new MovieNode("Inception", "Christopher Nolan", 2010, 8.6);
        head.next = new MovieNode("Matrix", "Lana Wachowski", 1999, 8.7);
        head.next.prev = head;
        head.next.next = new MovieNode("Interstellar", "Christopher Nolan", 2014, 8.6);
        head.next.next.prev = head.next;
        head.next.next.next = new MovieNode("Iron Man", "Jon Favreau", 2008, 7.9);
        head.next.next.next.prev = head.next.next;

        System.out.println("------ Original Movies ------");
        displayMovie(head);

        head = ms.addAtBeginning(head, new MovieNode("Phir Hera Pheri", "Neeraj Vora", 2006, 7.2));

        System.out.println("------ After Adding at Beginning ------");
        displayMovie(head);

        head = ms.addAtEnd(head, new MovieNode("Hum", "Dont Know", 2006, 1.2));

        System.out.println("------ After Adding at End ------");
        displayMovie(head);

        head = ms.addAtIndex(head, 2, new MovieNode("Andaz Apna Apna", "Rajkumar Santoshi", 1994, 8.2));

        System.out.println("------ After Adding at 2nd Index ------");
        displayMovie(head);
    }
}
