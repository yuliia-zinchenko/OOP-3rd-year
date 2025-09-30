package com.tourmanagement.data;

public abstract class Tour {
    private String name;
    private String transport;
    private String meals;
    private int numberOfDays;
    private double price;

    public Tour(String name, String transport, String meals, int numberOfDays, double price) {
        this.name = name;
        this.transport = transport;
        this.meals = meals;
        this.numberOfDays = numberOfDays;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Transport: " + transport + ", Meals: " + meals +
               ", Days: " + numberOfDays + ", Price: $" + price;
    }

    public abstract String getType();
}