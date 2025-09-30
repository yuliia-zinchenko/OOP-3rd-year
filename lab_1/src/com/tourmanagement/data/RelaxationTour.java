package com.tourmanagement.data;

public class RelaxationTour extends Tour {
    private String hotelName;

    public RelaxationTour(String name, String transport, String meals, int numberOfDays, double price, String hotelName) {
        super(name, transport, meals, numberOfDays, price);
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String getType() {
        return "Relaxation";
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + getType() + ", Hotel: " + hotelName;
    }
}