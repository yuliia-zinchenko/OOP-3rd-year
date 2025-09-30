package com.tourmanagement.util;

import com.tourmanagement.data.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @TempDir
    File tempDir; 
    @Test
    void loadToursFromFile_shouldIgnoreInvalidLines() throws IOException {

        File testFile = new File(tempDir, "invalid_format.txt");
        List<String> lines = Arrays.asList(
            "Relaxation,Test,Plane,All Inclusive,7,NOT_A_PRICE,Test Hotel", 
            "Excursion,Test,Bus,Breakfast,5,200.0,NOT_A_NUMBER", 
            "Medical,Valid Tour,Train,Full board,10,300.0,Test Clinic" 
        );
        Files.write(testFile.toPath(), lines);

        List<Tour> loadedTours = FileUtil.loadToursFromFile(testFile.getAbsolutePath());

        assertEquals(1, loadedTours.size()); 
        assertEquals("Valid Tour", loadedTours.get(0).getName());
    }
    @Test
    void loadToursFromFile_shouldLoadAllTypesCorrectly() throws IOException {
        File testFile = new File(tempDir, "test_tours.txt");
        List<String> lines = Arrays.asList(
            "Relaxation,Test Relax,Plane,All Inclusive,7,100.0,Test Hotel",
            "Excursion,Test Excursion,Bus,Breakfast,5,200.0,3",
            "Medical,Test Medical,Train,Full board,10,300.0,Test Clinic",
            "Cruise,Test Cruise,Ship,All Inclusive,8,400.0,Test Ship",
            "Invalid,Line,Format" 
        );
        Files.write(testFile.toPath(), lines);

        List<Tour> loadedTours = FileUtil.loadToursFromFile(testFile.getAbsolutePath());

        assertEquals(4, loadedTours.size()); 

        assertTrue(loadedTours.get(0) instanceof RelaxationTour);
        assertEquals("Test Relax", loadedTours.get(0).getName());
        assertEquals(100.0, loadedTours.get(0).getPrice());
        assertEquals("Test Hotel", ((RelaxationTour) loadedTours.get(0)).getHotelName());

        assertTrue(loadedTours.get(2) instanceof MedicalTour);
        assertEquals("Test Medical", loadedTours.get(2).getName());
        assertEquals("Test Clinic", ((MedicalTour) loadedTours.get(2)).getClinicName());
    }
}