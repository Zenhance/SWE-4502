package lab8_210042164.Services;

import lab8_210042164.API_classes.WeatherApi;
import lab8_210042164.interfaces.IWeatherService;

import java.io.IOException;

public class WeatherService implements IWeatherService {
    private static final String WeatherStackApiKey = "498c9df3f684ab09c3a5bd832507110a";

    @Override
    public void getWeatherByCity(String city) throws IOException {

        System.out.println("Getting weather by city: " + city);
        String weatherResponse = WeatherApi.getResponse(
                "http://api.weatherstack.com/current?access_key=" + WeatherStackApiKey + "&query=" + city
        );
    }

    @Override
    public void getWeatherByLocation(String latitude, String longitude, String city) {
        System.out.println("Getting weather by location: " + latitude + ", " + longitude + ", " + city);
    }

}
