package Lab8_210042166.Main;

import Lab8_210042166.Interface.ILocationService;
import Lab8_210042166.Interface.IWeatherService;
import Lab8_210042166.Service_Class.LocationService;
import Lab8_210042166.Service_Class.WeatherService;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main (String[] args ) throws IOException{
        Scanner scanner=new Scanner(System.in);
        ILocationService locationService=new LocationService();
        IWeatherService weatherService=new WeatherService();

        while (true)
        {
            System.out.println("Select location method: 1. By IP, 2. By City, 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                locationService.getLocationIP();
                weatherService.getWeatherThroughLocation(locationService.getLatitude(), locationService.getLongitude(), "Location");
            } else if (choice == 2) {
                System.out.println("Enter city name:");
                String city = scanner.nextLine();
                weatherService.getWeatherThroughCity(city);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
