package com.tourmanagement.service;

import com.tourmanagement.data.Tour;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TourService {
    private List<Tour> tours = new ArrayList<>();

    public void addTour(Tour tour) {
        tours.add(tour);
    }

    public List<Tour> getTours() {
        return new ArrayList<>(tours);
    }

    public List<Tour> findTours(String transport, String meals, int minDays, int maxDays) {
        return tours.stream()
                .filter(tour -> (transport == null || tour.getTransport().equalsIgnoreCase(transport)))
                .filter(tour -> (meals == null || tour.getMeals().equalsIgnoreCase(meals)))
                .filter(tour -> (tour.getNumberOfDays() >= minDays && tour.getNumberOfDays() <= maxDays))
                .collect(Collectors.toList());
    }

    public void sortToursByPrice() {
        tours.sort(Comparator.comparingDouble(Tour::getPrice));
    }

    public void sortToursByDays() {
        tours.sort(Comparator.comparingInt(Tour::getNumberOfDays));
    }

    public List<Tour> findToursByType(String type) {
        return tours.stream()
            .filter(tour -> tour.getType().equalsIgnoreCase(type.trim()))
            .collect(Collectors.toList());
    }
}