package com.tourmanagement.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CruiseTourTest {

    @Test
    void constructor_shouldSetAllFieldsCorrectly() {
        CruiseTour tour = new CruiseTour("Caribbean Cruise", "Ship", "All Inclusive", 8, 3500.0, "Odyssey");

        assertEquals("Caribbean Cruise", tour.getName());
        assertEquals("Ship", tour.getTransport());
        assertEquals(8, tour.getNumberOfDays());
        assertEquals(3500.0, tour.getPrice());
        assertEquals("Odyssey", tour.getShipName());
        assertEquals("Cruise", tour.getType());
    }
    @Test
    void getterSetter_shouldWorkCorrectly() {
        CruiseTour tour = new CruiseTour("A", "B", "C", 1, 1.0, "Old Ship");

        tour.setShipName("New Ship"); 

        assertEquals("New Ship", tour.getShipName()); 
    }

    @Test
    void toString_shouldContainUniqueFields() {
        CruiseTour tour = new CruiseTour("A", "B", "C", 1, 1.0, "Test Ship");

        String actualString = tour.toString();

        assertTrue(actualString.contains("Type: Cruise"));
        assertTrue(actualString.contains("Ship: Test Ship"));
    }
}