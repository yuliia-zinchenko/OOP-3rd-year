package com.tourmanagement.service;

import com.tourmanagement.data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TourServiceTest {

    private TourService tourService;

    @BeforeEach
    void setUp() {
        tourService = new TourService();
        tourService.addTour(new RelaxationTour("Antalya Holiday", "Plane", "All Inclusive", 7, 1500.0, "Grand Hotel"));
        tourService.addTour(new ExcursionTour("European Capitals", "Bus", "Breakfast", 10, 1200.0, 5));
        tourService.addTour(new MedicalTour("Heviz Spa", "Bus", "Full board", 14, 2500.0, "Heviz Center"));
        tourService.addTour(new CruiseTour("Caribbean Cruise", "Ship", "All Inclusive", 8, 3500.0, "Odyssey"));
    }

    @Test
    void addTour_shouldIncreaseTourListSize() {
        assertEquals(4, tourService.getTours().size());
        tourService.addTour(new RelaxationTour("Egypt Relax", "Plane", "All Inclusive", 5, 900.0, "Hilton"));
        assertEquals(5, tourService.getTours().size());
    }

    @Test
    void findToursByParameters_shouldReturnMatchingTours() {
        List<Tour> found = tourService.findTours("Bus", null, 9, 15);
        assertEquals(2, found.size());
        assertEquals("European Capitals", found.get(0).getName());
        assertEquals("Heviz Spa", found.get(1).getName());
    }

    @Test
    void findToursByType_shouldReturnCorrectTours_caseInsensitive() {
        List<Tour> found = tourService.findToursByType("cruise"); // Lowercase to test case-insensitivity
        assertEquals(1, found.size());
        assertEquals("Caribbean Cruise", found.get(0).getName());
    }

    @Test
    void findToursByType_shouldReturnEmptyListForUnknownType() {
        List<Tour> found = tourService.findToursByType("Shopping");
        assertTrue(found.isEmpty());
    }

    @Test
    void sortToursByPrice_shouldSortCorrectly() {
        tourService.sortToursByPrice();
        List<Tour> tours = tourService.getTours();
        assertEquals(1200.0, tours.get(0).getPrice());
        assertEquals(3500.0, tours.get(3).getPrice());
    }

    @Test
    void sortToursByDays_shouldSortCorrectly() {
        tourService.sortToursByDays();
        List<Tour> tours = tourService.getTours();
        assertEquals(7, tours.get(0).getNumberOfDays());
        assertEquals(14, tours.get(3).getNumberOfDays());
    }

    @Test
    void findToursByParameters_shouldReturnAllToursWhenNullCriteria() {
        List<Tour> found = tourService.findTours(null, null, 1, 100);
        assertEquals(4, found.size());
    }

    @Test
    void findToursByParameters_shouldBeCaseInsensitive_forSingleMatch() {
        List<Tour> found = tourService.findTours("plane", "all inclusive", 1, 10);
        assertEquals(1, found.size()); 
        assertEquals("Antalya Holiday", found.get(0).getName());
    }

    @Test
    void findToursByParameters_shouldBeCaseInsensitive_forMultipleMatches() {
        List<Tour> found = tourService.findTours(null, "all inclusive", 1, 10);
        assertEquals(2, found.size()); 
        assertTrue(found.stream().anyMatch(t -> t.getName().equals("Antalya Holiday")));
        assertTrue(found.stream().anyMatch(t -> t.getName().equals("Caribbean Cruise")));
    }

    @Test
    void findToursByParameters_shouldFilterByOneCriteria() {
        List<Tour> found = tourService.findTours("Bus", null, 1, 100);
        assertEquals(2, found.size());
    }
}