package lab8_210042164.Services;

import lab8_210042164.interfaces.IWeatherService;

public class WeatherService implements IWeatherService {
    private static final String WeatherApiKey = "498c9df3f684ab09c3a5bd832507110a";

    @Override
    public void getWeatherByCity(String city) {
        System.out.println("Getting weather by city: " + city);
    }

    @Override
    public void getWeatherByLocation(String latitude, String longitude, String city) {
        System.out.println("Getting weather by location: " + latitude + ", " + longitude + ", " + city);
    }

}
