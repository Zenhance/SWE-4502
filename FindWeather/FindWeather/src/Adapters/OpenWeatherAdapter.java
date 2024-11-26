package Adapters;

import Interface.WeatherProvider;

import Models.WeatherData;
import org.json.JSONObject;

public class OpenWeatherAdapter implements WeatherProvider {

    private static final String API_KEY = "aad8726c991abef5cc7e5ad0030ba60e";

    @Override
    public WeatherData getWeather(String city, double latitude, double longitude) {
        try {
            

        } catch (Exception e) {
            System.out.println("Error in OpenWeatherAdapter.getWeather()");
            return null;
        }
    }




}
