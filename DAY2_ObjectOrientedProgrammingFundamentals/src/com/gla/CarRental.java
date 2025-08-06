package com.gla;
public class CarRental {
    
    private String customerName;
    private String carModel;
    private int rentalDays;

    
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    
    public double calculateTotalCost(double dailyRate) {
        return rentalDays * dailyRate;
    }
    public static void main(String[] args) {
    	CarRental carRental = new CarRental("raghav","BMW",5);
    	System.out.println(carRental.calculateTotalCost(200.00));
    }
}