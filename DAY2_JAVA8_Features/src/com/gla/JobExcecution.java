package com.gla;

public class JobExcecution {
    public static void main(String[] args) {
        Runnable job = () -> {
            System.out.println("Background job running...");
        };

        new Thread(job).start();
    }
}

