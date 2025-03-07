import java.util.Scanner;

import Models.WeatherData;
import WeatherServices.OpenWeatherProvider;
import WeatherServices.OpenWeatherProxy;
import WeatherServices.WeatherStackProxy;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        // // OpenWeatherProvider provider = new OpenWeatherProvider();
        WeatherStackProxy proxy = new WeatherStackProxy();
        WeatherData weatherData;

        // if (weatherData != null) {
        //     weatherData.displayData();
        // } else {
        //     System.out.println("Failed to retrieve weather data.");
        // }

        Scanner scanner = new Scanner(System.in);

        while (true) {
                System.out.println("Select location method: 1. By IP, 2. By City, 3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Getting weather data by IP...");
                        weatherData = proxy.getWeatherData("Dhaka");
                        weatherData.displayData();
                        break;
                    case 2:
                        System.out.print("Enter city name: ");
                        String city = scanner.nextLine();
                        System.out.println("Getting weather data by city...");
                        weatherData = proxy.getWeatherData(city);
                        weatherData.displayData();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
    }
}
