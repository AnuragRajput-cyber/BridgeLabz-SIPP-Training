package com.gla;
public class Patient {
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    private static String hospitalName;
    private static int totalPatients = 0;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void setHospitalName(String hospitalName) {
        Patient.hospitalName = hospitalName;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public int getPatientID() {
        return patientID;
    }

    public void displayPatientInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Hospital: " + hospitalName);
    }
    public static void main(String[] args) {
        Patient.setHospitalName("chaumuhan Asptal");
        Patient patient1 = new Patient("Anurag", 21, "Flu", 101);
        Patient patient2 = new Patient("raghav", 19, "Cold", 102);
        patient1.displayPatientInfo();
        System.out.println();
        patient2.displayPatientInfo();
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}