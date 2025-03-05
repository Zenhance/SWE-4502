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
    }
}
