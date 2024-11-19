package Main;

import Interfaces.ILocationService;
import Interfaces.IWeatherService;
import Model.LocationService;
import Model.WeatherService;

import java.io.IOException;
import java.util.Scanner;

public class WeatherConsoleApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ILocationService locationService = new LocationService();
        IWeatherService weatherService = new WeatherService();
    }
}
