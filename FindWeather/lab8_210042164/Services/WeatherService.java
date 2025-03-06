package lab8_210042164.Services;

import lab8_210042164.API_classes.WeatherApi;
import lab8_210042164.interfaces.IWeatherService;

import java.io.IOException;

public class WeatherService implements IWeatherService {
    private static final String WeatherStackApiKey = "498c9df3f684ab09c3a5bd832507110a";
    private void displayWeatherData(String city, String weatherResponse) {
        String temperature = WeatherApi.extractValue(weatherResponse, "\"temperature\":", ",");
        String weatherDescription = WeatherApi.extractValue(weatherResponse, "\"weather_descriptions\":[\"", "\"]");
        System.out.println("Weather in " + city + ": " + temperature + "°C, " + weatherDescription);
    }

    @Override
    public void getWeatherByCity(String city) throws IOException {

        System.out.println("Getting weather by city: " + city);
        String weatherResponse = WeatherApi.getResponse(
                "http://api.weatherstack.com/current?access_key=" + WeatherStackApiKey + "&query=" + city
        );
        displayWeatherData(city, weatherResponse);

    }

    @Override
    public void getWeatherByLocation(String latitude, String longitude, String city) throws IOException {
        System.out.println("Getting weather by location: " + latitude + ", " + longitude + ", " + city);

        String weatherResponse = WeatherApi.getResponse(
                "http://api.weatherstack.com/current?access_key=" + WeatherStackApiKey + "&query=" + latitude + "," + longitude
        );
        displayWeatherData(city, weatherResponse);
    }


}
