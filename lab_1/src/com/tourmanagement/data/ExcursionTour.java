package com.tourmanagement.data;

public class ExcursionTour extends Tour {
    private int numberOfExcursions;

    public ExcursionTour(String name, String transport, String meals, int numberOfDays, double price, int numberOfExcursions) {
        super(name, transport, meals, numberOfDays, price);
        this.numberOfExcursions = numberOfExcursions;
    }

    public int getNumberOfExcursions() {
        return numberOfExcursions;
    }

    public void setNumberOfExcursions(int numberOfExcursions) {
        this.numberOfExcursions = numberOfExcursions;
    }

    @Override
    public String getType() {
        return "Excursion";
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + getType() + ", Number of Excursions: " + numberOfExcursions;    }
    }