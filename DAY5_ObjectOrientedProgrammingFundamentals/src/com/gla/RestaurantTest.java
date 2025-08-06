// Superclass
package com.gla;
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass Chef implementing Worker
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is preparing " + specialty + " dishes.");
    }
}

// Subclass Waiter implementing Worker
class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving " + tablesAssigned + " tables.");
    }
}

// Main to test
public class RestaurantTest {
    public static void main(String[] args) {
        Worker chef = new Chef("Gordon Ramsay", 1, "Italian");
        Worker waiter = new Waiter("John Doe", 2, 5);

        chef.performDuties();
        waiter.performDuties();
    }
}
