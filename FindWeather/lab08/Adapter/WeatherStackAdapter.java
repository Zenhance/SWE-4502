package Adapter;

import Model.Location;
import Model.Weather;
import API.WeatherStackAPI;

import java.io.IOException;

import API.WeatherStackAPI;

import java.io.IOException;
public class WeatherStackAdapter  implements IWeatherAdapter{
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
