package Lab8_210042166.Service_Class;

import Lab8_210042166.Interface.IWeatherService;

import java.io.IOException;
import Lab8_210042166.API_Class.weatherAPI

public class WeatherService implements IWeatherService {

    private static final String weatherStack_Key="76e91d82542ba4d15bf0ef04c7955f93";

    @Override
    public void getWeatherThroughCity(String city) throws IOException {
        System.out.println("Weather data for city: " + city);

        String weatherResponse = weatherAPI.getResponse(
                "http://api.weatherstack.com/current?access_key=" + weatherStack_Key + "&query=" + city
        );

    }
    public void getWeatherThroughLocation(String latitude, String longitude, String city)throws IOException{
        System.out.println("Weather data for the location...");
        String weatherResponse = weatherAPI.getResponse(
                "http://api.weatherstack.com/current?access_key=" + weatherStack_Key + "&query=" + latitude + "," + longitude
        );
    }



}
