package com.tourmanagement.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RelaxationTourTest {

    @Test
    void constructor_shouldSetAllFieldsCorrectly() {
        RelaxationTour tour = new RelaxationTour("Antalya Holiday", "Plane", "All Inclusive", 7, 1500.0, "Grand Hotel");

        assertEquals("Antalya Holiday", tour.getName());
        assertEquals("Plane", tour.getTransport());
        assertEquals("All Inclusive", tour.getMeals());
        assertEquals(7, tour.getNumberOfDays());
        assertEquals(1500.0, tour.getPrice());
        assertEquals("Grand Hotel", tour.getHotelName());
        assertEquals("Relaxation", tour.getType());
    }
    @Test
    void getterSetter_shouldWorkCorrectly() {

        RelaxationTour tour = new RelaxationTour("A", "B", "C", 1, 1.0, "Old Hotel");

        tour.setHotelName("New Hotel"); 

        assertEquals("New Hotel", tour.getHotelName()); 
    }

    @Test
    void toString_shouldContainUniqueFields() {

        RelaxationTour tour = new RelaxationTour("A", "B", "C", 1, 1.0, "Test Hotel");
        String expectedPartial = "Type: Relaxation, Hotel: Test Hotel";

        String actualString = tour.toString();

        assertTrue(actualString.contains(expectedPartial)); 
    }

}