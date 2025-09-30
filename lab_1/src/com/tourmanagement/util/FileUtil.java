package com.tourmanagement.util;

import com.tourmanagement.data.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil {

    private FileUtil() {

    }

    public static List<Tour> loadToursFromFile(String filename) {
        List<Tour> tours = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 7) {
                        continue; 
                    }

                    String type = parts[0];
                    String name = parts[1];
                    String transport = parts[2];
                    String meals = parts[3];
                    int days = Integer.parseInt(parts[4].trim()); 
                    double price = Double.parseDouble(parts[5].trim());
                    String extra = parts[6];
                    
                    if (type.equalsIgnoreCase("Relaxation")) {
                        tours.add(new RelaxationTour(name, transport, meals, days, price, extra));
                    } else if (type.equalsIgnoreCase("Excursion")) {
                        tours.add(new ExcursionTour(name, transport, meals, days, price, Integer.parseInt(extra.trim())));
                    } else if (type.equalsIgnoreCase("Medical")) {
                        tours.add(new MedicalTour(name, transport, meals, days, price, extra));
                    } else if (type.equalsIgnoreCase("Cruise")) {
                        tours.add(new CruiseTour(name, transport, meals, days, price, extra));
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Skipping malformed line due to parsing error: \"" + line + "\"");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return tours;
    }
}