package com.gla;

public class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String id, String location, double distance, int expected, int actual) {
        super(id, location, distance, expected, actual);
    }

    public boolean isCritical() {
        return false;
    }

    public String getType() {
        return "RestCheckpoint";
    }

    public double calculatePenalty() {
        if (!isDelayed()) return 0;
        int delay = actualDuration - expectedDuration;
        return delay > 30 ? delay * 0.5 : 0.0;
    }
}
