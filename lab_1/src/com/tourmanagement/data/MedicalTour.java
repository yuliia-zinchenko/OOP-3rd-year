package com.tourmanagement.data;

public class MedicalTour extends Tour {
    private String clinicName;

    public MedicalTour(String name, String transport, String meals, int numberOfDays, double price, String clinicName) {
        super(name, transport, meals, numberOfDays, price);
        this.clinicName = clinicName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public String getType() {
        return "Medical";
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + getType() + ", Clinic: " + clinicName;
    }
}