package com.gla;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    public StudentNode addAtBeginning(StudentNode head, int rollNumber, String name, int age, String grade) {
        StudentNode node = new StudentNode(rollNumber, name, age, grade);
        node.next = head;
        return node;
    }

    
    public StudentNode addAtEnd(StudentNode head, int rollNumber, String name, int age, String grade) {
        StudentNode node = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            return node;
        }
        StudentNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return head;
    }

    
    public StudentNode addAtIndex(StudentNode head, int index, int rollNumber, String name, int age, String grade) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        if (index == 0) {
            return addAtBeginning(head, rollNumber, name, age, grade);
        }

        StudentNode curr = head;
        int count = 0;
        while (curr != null && count < index - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        StudentNode node = new StudentNode(rollNumber, name, age, grade);
        node.next = curr.next;
        curr.next = node;
        return head;
    }

    
    public StudentNode deleteByRollNumber(StudentNode head, int rollNumber) {
        if (head == null) {
            return null;
        }
        if (head.rollNumber == rollNumber) {
            return head.next;
        }
        StudentNode curr = head;
        while (curr.next != null) {
            if (curr.next.rollNumber == rollNumber) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    
    public StudentNode searchByRollNumber(StudentNode head, int rollNumber) {
        StudentNode curr = head;
        while (curr != null) {
            if (curr.rollNumber == rollNumber) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    
    public boolean updateGrade(StudentNode head, int rollNumber, String newGrade) {
        StudentNode curr = head;
        while (curr != null) {
            if (curr.rollNumber == rollNumber) {
                curr.grade = newGrade;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    
    public void displayAll(StudentNode head) {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        StudentNode curr = head;
        while (curr != null) {
            System.out.println("Roll Number: " + curr.rollNumber +
                               ", Name: " + curr.name +
                               ", Age: " + curr.age +
                               ", Grade: " + curr.grade);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();
        StudentNode head = null;

        
        head = srm.addAtEnd(head, 1, "Anurag", 20, "A");
        head = srm.addAtEnd(head, 2, "Raghav", 21, "B");
        head = srm.addAtBeginning(head, 3, "Prashant", 22, "C");
        head = srm.addAtIndex(head, 1, 4, "Aditya", 19, "A");

        
        System.out.println("All student records:");
        srm.displayAll(head);
        StudentNode found = srm.searchByRollNumber(head, 2);
        System.out.println(found.name);

        boolean updated = srm.updateGrade(head, 2, "A+");
        System.out.println(srm.deleteByRollNumber(head, 3).name);
        srm.displayAll(head);
    }
}
