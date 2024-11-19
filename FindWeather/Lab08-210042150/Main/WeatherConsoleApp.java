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
    }
}
