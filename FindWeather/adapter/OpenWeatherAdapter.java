package adapter;

import api.OpenWeatherAPI;
import models.WeatherData;
import org.json.JSONObject;

public class OpenWeatherAdapter implements WeatherProvider {
    private final OpenWeatherAPI api;

    public OpenWeatherAdapter() {
        this.api = new OpenWeatherAPI();
    }

    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {
        JSONObject response = api.getWeatherByIP(latitude, longitude);
        return parseWeatherData(response, "Location via IP");
    }

    @Override
    public WeatherData getWeatherByCity(String city) throws Exception {
        JSONObject response = api.getWeatherByCity(city);
        return parseWeatherData(response, city);
    }

    private WeatherData parseWeatherData(JSONObject response, String locationName) throws Exception {
        if (!response.has("main") || !response.has("weather")) {
            throw new Exception("Invalid response from OpenWeather API");
        }

        double temperature = response.getJSONObject("main").getDouble("temp");
        String conditions = response.getJSONArray("weather").getJSONObject(0).getString("description");

        return new WeatherData(locationName, temperature, conditions, "OpenWeather");
    }
}
