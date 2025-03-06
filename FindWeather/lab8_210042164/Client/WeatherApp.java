package lab8_210042164.Client;

import lab8_210042164.Services.LocationService;
import lab8_210042164.Services.WeatherService;
import lab8_210042164.interfaces.ILocationService;
import lab8_210042164.interfaces.IWeatherService;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ILocationService locationService = new LocationService();
        IWeatherService weatherService = new WeatherService();

        while (true) {
            System.out.println("1. Get weather by city");
            System.out.println("2. Get weather by location");
            System.out.println("3. Get location by IP");
            System.out.println("4. Get city by IP");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    weatherService.getWeatherByCity(city);
                    break;
                case 2:
                    System.out.print("Enter latitude: ");
                    String latitude = scanner.nextLine();
                    System.out.print("Enter longitude: ");
                    String longitude = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city2 = scanner.nextLine();
                    weatherService.getWeatherByLocation(latitude, longitude, city2);
                    break;
                case 3:
                    locationService.getLocationByIP();
                    break;
                case 4:
                    locationService.getCity();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
