package com.findweather;

import com.findweather.models.Location;
import com.findweather.models.WeatherData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocationService locationService = new LocationService();
        WeatherService weatherService = new WeatherService();

        boolean running = true; // Add a loop control variable

        while (running) { // Enclose the main logic in a loop
            System.out.println("\nSelect location method: 1. By IP, 2. By City, 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Location location = null;
            if (choice == 1) {
                //location = locationService.getLocationByIP();  // Comment out IP retrieval
                location = new Location("Dhaka", 0, 0);  // Always use Dhaka
            } else if (choice == 2) {
                System.out.println("Enter city name:");
                String cityName = scanner.nextLine();
                location = new Location(cityName, 0, 0);
            } else if (choice == 3) {  // Add an exit option
                System.out.println("Exiting...");
                running = false; // Set the loop control variable to false to exit
                continue; //Skip to the end to close the scanner and exit
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue; // Restart the loop
            }

            if (location != null) {
                WeatherData weather = weatherService.getWeather(location.getCity());
                if (weather != null) {
                    System.out.println("Weather in " + location.getCity() + " from " + weather.getSource() + ": " +
                            weather.getTemperature() + "°C, " + weather.getCondition());
                } else {
                    System.out.println("Could not retrieve weather data for " + location.getCity());
                }
            }
        }

        scanner.close(); // Close the scanner outside the loop when exiting the program
    }
}
