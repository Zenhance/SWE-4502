import LocationAPI.GeoLocation;
import Model.Location;
import Model.Weather;
import WeatherService.IWeatherService;
import WeatherService.RealWeatherService;
import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;










public class main {
    public static void main(String[] args) throws IOException, JSONException {
        Scanner scanner = new Scanner(System.in);
        RealWeatherService weatherService = new RealWeatherService();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Choose Weather Service");
            System.out.println("2. Get Weather by City");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1 -> {
                    int apiChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (apiChoice == 1) {System.out.println("Select Weather API: 1. WeatherStack, 2. OpenWeather");
                        RealWeatherService.useWeatherStack = true;
                        System.out.println("WeatherStack selected as the API.");
                    } else if (apiChoice == 2) {
                        RealWeatherService.useWeatherStack = false;
                        System.out.println("OpenWeather selected as the API.");
                    } else {

                        System.out.println("Invalid choice. Using default API.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    Location location = GeoLocation.get_Location_by_city(city);
                    displayWeather(weatherService, location);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayWeather(IWeatherService weatherService, Location location) throws IOException {
        if (location != null) {
            System.out.println("Location Info: City: " + location.getCity() +
                    ", Latitude: " + location.getLatitude() +
                    ", Longitude: " + location.getLongitude());
            Weather weather = weatherService.getWeather(location);
            if (weather != null) {
                weather.DisplayWeather();

