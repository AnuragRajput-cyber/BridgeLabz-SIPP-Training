package com.gla;

public class DeliveryCheckpoint extends Checkpoint {
    public DeliveryCheckpoint(String id, String location, double distance, int expected, int actual) {
        super(id, location, distance, expected, actual);
    }

    public boolean isCritical() {
        return true;
    }

    public String getType() {
        return "DeliveryCheckpoint";
    }

    public double calculatePenalty() {
        if (!isDelayed()) return 0;
        return (actualDuration - expectedDuration) * 2.0;
    }
}
