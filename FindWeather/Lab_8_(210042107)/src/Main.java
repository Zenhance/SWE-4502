import LocationAPI.GeoLocation;
import LocationAPI.IPLocation;
import Model.Location;
import Model.Weather;
import WeatherService.IWeatherService;
import WeatherService.ProxyWeatherService;
import WeatherService.RealWeatherService;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        IWeatherService weatherService = new ProxyWeatherService();

        //RealWeatherService realWeatherService=new RealWeatherService();//Proxy theke nicchi na eiber, Realtime

        while (true) {
            System.out.println("Select location method: 1. By IP, 2. By City, 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                break;
            }

            Location location = null;
            if (choice == 1) {
                location = IPLocation.get_Location_by_IP();
            } else if (choice == 2) {
                System.out.print("Enter city name: ");
                String city = scanner.nextLine();
                location = GeoLocation.get_Location_by_city(city);
            }

            if (location != null) {
                System.out.println("City: " + location.getCity() + " (Latitude, Longitude) => (" + location.getLatitude() + ", " + location.getLongitude() + ")");

                Weather weather = weatherService.getWeather(location);
                //Weather weather= realWeatherService.getWeather(location);
                if (weather != null) {
                    weather.DisplayWeather();
                }
                System.out.println("________________________________________________________");
            }
        }
        scanner.close();
    }
}