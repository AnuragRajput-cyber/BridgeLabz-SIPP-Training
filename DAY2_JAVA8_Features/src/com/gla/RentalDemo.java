package com.gla;

interface Rentable {
    void rent();
    void returnVehicle();
}

class Car implements Rentable {
    public void rent() { System.out.println("Car rented"); }
    public void returnVehicle() { System.out.println("Car returned"); }
}

class Bike implements Rentable {
    public void rent() { System.out.println("Bike rented"); }
    public void returnVehicle() { System.out.println("Bike returned"); }
}

public class RentalDemo {
    public static void main(String[] args) {
        Rentable r = new Car();
        r.rent();
        r.returnVehicle();
    }
}

