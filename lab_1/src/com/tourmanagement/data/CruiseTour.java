package com.tourmanagement.data;

public class CruiseTour extends Tour {
    private String shipName;

    public CruiseTour(String name, String transport, String meals, int numberOfDays, double price, String shipName) {
        super(name, transport, meals, numberOfDays, price);
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Override
    public String getType() {
        return "Cruise";
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + getType() + ", Ship: " + shipName;
    }
}   