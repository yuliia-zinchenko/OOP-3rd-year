package com.tourmanagement.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedicalTourTest {

    @Test
    void constructor_shouldSetAllFieldsCorrectly() {
        MedicalTour tour = new MedicalTour("Heviz Spa", "Bus", "Full board", 14, 2500.0, "Heviz Center");

        assertEquals("Heviz Spa", tour.getName());
        assertEquals("Bus", tour.getTransport());
        assertEquals(14, tour.getNumberOfDays());
        assertEquals(2500.0, tour.getPrice());
        assertEquals("Heviz Center", tour.getClinicName());
        assertEquals("Medical", tour.getType());
    }
        @Test
    void getterSetter_shouldWorkCorrectly() {
        MedicalTour tour = new MedicalTour("A", "B", "C", 1, 1.0, "Old Clinic");

        tour.setClinicName("New Clinic");

        assertEquals("New Clinic", tour.getClinicName()); 
    }

    @Test
    void toString_shouldContainUniqueFields() {
        MedicalTour tour = new MedicalTour("A", "B", "C", 1, 1.0, "Test Clinic");
        String actualString = tour.toString();

        assertTrue(actualString.contains("Type: Medical"));
        assertTrue(actualString.contains("Clinic: Test Clinic"));
    }
}