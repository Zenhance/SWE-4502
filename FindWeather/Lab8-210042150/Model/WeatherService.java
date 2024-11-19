package Model;

import Interfaces.IWeatherService;
import WeatherAPI.weatherAPIUtil;

import java.io.IOException;

public class WeatherService implements IWeatherService {
    private static final String WEATHERSTACK_API_KEY = "0d65452eba6c09f62cc24ff0381ab83e";

    @Override
    public void getWeatherByCity(String city) throws IOException {
        System.out.println("Getting weather data for city: " + city);

        String weatherResponse = weatherAPIUtil.getResponse(
                "http://api.weatherstack.com/current?access_key=" + WEATHERSTACK_API_KEY + "&query=" + city
        );
    }

}
