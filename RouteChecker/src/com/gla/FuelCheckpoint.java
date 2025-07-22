package com.gla;

public class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String id, String location, double distance, int expected, int actual) {
        super(id, location, distance, expected, actual);
    }

    public boolean isCritical() {
        return true;
    }

    public String getType() {
        return "FuelCheckpoint";
    }

    public double calculatePenalty() {
        return isDelayed() ? 10.0 : 0.0;
    }
}
