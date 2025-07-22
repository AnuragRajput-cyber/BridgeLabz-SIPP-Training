package com.gla;

public class Driver {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    public void addCheckpoint(Checkpoint cp) {
        routeHistory.addCheckpoint(cp);
    }

    public void printRouteSummary() {
        System.out.println("Driver: " + driverId + " – " + name);
        System.out.println("Route Summary:");
        routeHistory.printRoute();
        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty = routeHistory.computeTotalPenalty();
        double routeScore = totalDistance - totalPenalty;
        System.out.printf("Total Distance: %.1f km%n", totalDistance);
        System.out.printf("Total Penalty: %.1f%n", totalPenalty);
        System.out.printf("Route Score: %.1f%n", routeScore);
        System.out.println("Critical Route Check: " + (routeHistory.checkCriticalCheckpointsPresent() ? "All required checkpoints present" : "Missing critical checkpoints!"));
    }
}
