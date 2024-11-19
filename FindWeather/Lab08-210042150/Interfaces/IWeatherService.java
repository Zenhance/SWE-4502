package Interfaces;

import java.io.IOException;

public interface IWeatherService {
    void getWeatherByCity(String city) throws IOException;
    void getWeatherByLocation(String latitude, String longitude, String city) throws IOException;
}
