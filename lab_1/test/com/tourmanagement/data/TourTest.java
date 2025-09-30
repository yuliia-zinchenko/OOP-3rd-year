package com.tourmanagement.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    private static class ConcreteTour extends Tour {
        public ConcreteTour(String name, String transport, String meals, int numberOfDays, double price) {
            super(name, transport, meals, numberOfDays, price);
        }

        @Override
        public String getType() {
            return "ConcreteTestType"; 
        }
    }

    private ConcreteTour tour;

    @BeforeEach
    void setUp() {
        tour = new ConcreteTour("Test Tour Name", "Test Transport", "Test Meals", 5, 100.0);
    }

    @Test
    void constructor_shouldInitializeAllFieldsCorrectly() {
        assertEquals("Test Tour Name", tour.getName());
        assertEquals("Test Transport", tour.getTransport());
        assertEquals("Test Meals", tour.getMeals());
        assertEquals(5, tour.getNumberOfDays());
        assertEquals(100.0, tour.getPrice());
    }

    @Test
    void setName_shouldUpdateName() {

        tour.setName("New Name");

        assertEquals("New Name", tour.getName());
    }

    @Test
    void setTransport_shouldUpdateTransport() {

        tour.setTransport("New Transport");

        assertEquals("New Transport", tour.getTransport());
    }

    @Test
    void setMeals_shouldUpdateMeals() {

        tour.setMeals("New Meals");

        assertEquals("New Meals", tour.getMeals());
    }

    @Test
    void setNumberOfDays_shouldUpdateNumberOfDays() {

        tour.setNumberOfDays(10);

        assertEquals(10, tour.getNumberOfDays());
    }

    @Test
    void setPrice_shouldUpdatePrice() {
        tour.setPrice(200.50);
        assertEquals(200.50, tour.getPrice());
    }

    @Test
    void toString_shouldReturnCorrectlyFormattedString() {

        String expectedString = "Name: Test Tour Name, Transport: Test Transport, Meals: Test Meals, Days: 5, Price: $100.0";

        String actualString = tour.toString();

        assertEquals(expectedString, actualString);
    }
}