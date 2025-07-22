package com.gla;

public class RouteTrackerSystem {
    public static void main(String[] args) {
        Driver driver = new Driver("101", "Raghav Awasthi");

        driver.addCheckpoint(new DeliveryCheckpoint("2215", "Mera Ghar", 30.0, 60, 70));
        driver.addCheckpoint(new FuelCheckpoint("2213", "Indian Oil", 40.0, 10, 10));
        driver.addCheckpoint(new RestCheckpoint("2245", "Oyo", 20.0, 60, 65));
        driver.addCheckpoint(new DeliveryCheckpoint("7895", "Hospital", 30.0, 45, 60));

        driver.printRouteSummary();
    }
}
