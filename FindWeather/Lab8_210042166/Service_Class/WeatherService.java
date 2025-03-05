package Lab8_210042166.Service_Class;

import Lab8_210042166.Interface.IWeatherService;

import java.io.IOException;
import Lab8_210042166.API_Class.weatherAPI;

public class WeatherService implements IWeatherService {

    private static final String weatherStack_Key="76e91d82542ba4d15bf0ef04c7955f93";

    @Override
    public void getWeatherThroughCity(String city) throws IOException {

        System.out.println("Weather data for city: " + city);

        String weatherResponse = weatherAPI.getResponse(
                "http://api.weatherstack.com/current?access_key=" + weatherStack_Key + "&query=" + city
        );
        displayWeatherData(city, weatherResponse);

    }
    public void getWeatherThroughLocation(String latitude, String longitude, String city)throws IOException{
        System.out.println("Weather data for the location...");
        String weatherResponse = weatherAPI.getResponse(
                "http://api.weatherstack.com/current?access_key=" + weatherStack_Key + "&query=" + latitude + "," + longitude
        );
        displayWeatherData(city, weatherResponse);
    }

    private void displayWeatherData(String city, String weatherResponse) {
        String temperature = weatherAPI.getValue(weatherResponse, "\"temperature\":", ",");
        String weatherDescription = weatherAPI.getValue(weatherResponse, "\"weather_descriptions\":[\"", "\"]");

        System.out.println("City: " + city);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Weather: " + weatherDescription);
    }

    }
