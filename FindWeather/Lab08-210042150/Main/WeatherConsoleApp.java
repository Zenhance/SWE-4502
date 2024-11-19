package Main;

import java.io.IOException;
import java.util.Scanner;
import Interfaces.IWeatherService;
import Interfaces.ILocationService;
import Model.LocationService;
import Model.WeatherService;


public class WeatherConsoleApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ILocationService locationService = new LocationService();
        IWeatherService weatherService = new WeatherService();

        while (true) {
            System.out.println("Select location method: 1. By IP, 2. By City, 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
