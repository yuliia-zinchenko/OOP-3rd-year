package com.tourmanagement.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExcursionTourTest {

    @Test
    void constructor_shouldSetAllFieldsCorrectly() {
        ExcursionTour tour = new ExcursionTour("European Capitals", "Bus", "Breakfast", 10, 1200.0, 5);

        assertEquals("European Capitals", tour.getName());
        assertEquals("Bus", tour.getTransport());
        assertEquals(10, tour.getNumberOfDays());
        assertEquals(1200.0, tour.getPrice());
        assertEquals(5, tour.getNumberOfExcursions());
        assertEquals("Excursion", tour.getType());
    }
    @Test
    void getterSetter_shouldWorkCorrectly() {
 
        ExcursionTour tour = new ExcursionTour("A", "B", "C", 1, 1.0, 5);

        tour.setNumberOfExcursions(10); 

        assertEquals(10, tour.getNumberOfExcursions()); 
    }

    @Test
    void toString_shouldContainUniqueFields() {
        ExcursionTour tour = new ExcursionTour("A", "B", "C", 1, 1.0, 3);

        String actualString = tour.toString();

        assertTrue(actualString.contains("Type: Excursion"));
        assertTrue(actualString.contains("Number of Excursions: 3"));
    }
}