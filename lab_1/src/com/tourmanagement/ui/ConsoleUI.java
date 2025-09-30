package com.tourmanagement.ui;

import com.tourmanagement.data.CruiseTour;
import com.tourmanagement.data.ExcursionTour;
import com.tourmanagement.data.MedicalTour;
import com.tourmanagement.data.RelaxationTour;
import com.tourmanagement.data.Tour;
import com.tourmanagement.service.TourService;
import com.tourmanagement.util.FileUtil;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleUI {
    private TourService tourService = new TourService();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }

    public void start() {
        initializeData(); 
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show all tours");
            System.out.println("2. Find tours by parameters");
            System.out.println("3. Sort tours by price");
            System.out.println("4. Sort tours by number of days");
            System.out.println("5. Filter tours by type");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayTours(tourService.getTours());
                    break;
                case 2:
                    selectTours();
                    break;
                case 3:
                    tourService.sortToursByPrice();
                    System.out.println("Tours have been sorted by price.");
                    displayTours(tourService.getTours());
                    break;
                case 4:
                    tourService.sortToursByDays();
                    System.out.println("Tours have been sorted by number of days.");
                    displayTours(tourService.getTours());
                    break;
                case 5: 
                    selectToursByType();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void selectToursByType() {
        System.out.println("\nAvailable tour types: Relaxation, Excursion, Medical, Cruise");
        System.out.print("Please enter the type you want to see: ");
        String chosenType = scanner.nextLine();

        List<Tour> foundTours = tourService.findToursByType(chosenType);
        displayTours(foundTours);
    }

    private int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a number.");
            scanner.nextLine(); 
            return -1; 
        }
    }

    private void initializeData() {
        List<Tour> loadedTours = FileUtil.loadToursFromFile("tours.txt");
        for (Tour tour : loadedTours) {
            tourService.addTour(tour);
        }
    }
    
private void displayTours(List<Tour> tours) {
    if (tours.isEmpty()) {
        System.out.println("No tours found.");
        return;
    }

    System.out.println("\n--- List of available tours ---");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("| %-28s | %-12s | %-12s | %-18s | %-5s | %-10s | %-25s |%n", 
                      "Name", "Type", "Transport", "Meals", "Days", "Price", "Details");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

    for (Tour tour : tours) {
        String details = "";
        if (tour instanceof RelaxationTour) {
            details = "Hotel: " + ((RelaxationTour) tour).getHotelName();
        } else if (tour instanceof ExcursionTour) {
            details = "Excursions: " + ((ExcursionTour) tour).getNumberOfExcursions();
        } else if (tour instanceof MedicalTour) {
            details = "Clinic: " + ((MedicalTour) tour).getClinicName();
        } else if (tour instanceof CruiseTour) {
            details = "Ship: " + ((CruiseTour) tour).getShipName();
        }

        System.out.printf("| %-28s | %-12s | %-12s | %-18s | %-5d | $%-9.2f | %-25s |%n",
                          tour.getName(),
                          tour.getType(), 
                          tour.getTransport(),
                          tour.getMeals(),
                          tour.getNumberOfDays(),
                          tour.getPrice(),
                          details);
    }
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
}

    private void selectTours() {
        System.out.print("Enter transport type (Plane, Bus, Train or leave empty): ");
        String transport = scanner.nextLine();
        System.out.print("Enter meal type (All Inclusive, Breakfast, No meals or leave empty): ");
        String meals = scanner.nextLine();
        System.out.print("Enter minimum number of days: ");
        int minDays = scanner.nextInt();
        System.out.print("Enter maximum number of days: ");
        int maxDays = scanner.nextInt();
        scanner.nextLine(); 

        List<Tour> foundTours = tourService.findTours(
            transport.isEmpty() ? null : transport,
            meals.isEmpty() ? null : meals,
            minDays,
            maxDays);
        displayTours(foundTours);
    }
}