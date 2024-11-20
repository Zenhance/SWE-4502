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


