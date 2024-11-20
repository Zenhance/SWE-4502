package Adapter;

import Model.Location;
import Model.Weather;
import WeatherAPI.WeatherStackAPI;

import java.io.IOException;
public class WeatherStackAdapter {
    @Override
    public Weather getWeather(Location location) throws IOException {
        try {
            return WeatherStackAPI.Get_Weather(location);
        }catch (org.json.JSONException e) {
            System.err.println("Error parsing JSON in WeatherStackAPI: " + e.getMessage());

            return null;
        }
    }
    }
