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

