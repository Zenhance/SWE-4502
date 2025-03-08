package com.findweather;

import com.findweather.models.WeatherData;
import org.json.JSONObject;

public class WeatherService {
    private static final String OPEN_WEATHER_API_KEY = "083c19622212e8e141b5aafece225ae1";
    private static final String WEATHER_STACK_API_KEY = "fb3c18808c33d25ddfb3c44930aab466";

    public WeatherData getWeather(String location) {
        WeatherData cachedData = CacheManager.getWeatherFromCache(location);
        if (cachedData != null) {
            return cachedData;
        }

        if (RateLimiter.isRateLimited("OpenWeather")) {
            System.out.println("Rate limit reached for OpenWeather, switching to WeatherStack...");
            return getWeatherFromWeatherStack(location);
        }

        WeatherData weather = getWeatherFromOpenWeather(location);
        if (weather == null) {
            weather = getWeatherFromWeatherStack(location);
        }

        if (weather != null) {
            CacheManager.saveWeatherToCache(location, weather);
        }
        return weather;
    }

    private WeatherData getWeatherFromOpenWeather(String location) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + location +
                "&appid=" + OPEN_WEATHER_API_KEY + "&units=metric";
        JSONObject response = APIClient.getJSONResponse(apiUrl);

        if (response != null) {
            double temp = response.getJSONObject("main").getDouble("temp");
            String condition = response.getJSONArray("weather").getJSONObject(0).getString("description");
            RateLimiter.markRequest("OpenWeather");
            return new WeatherData(location, temp, condition, "OpenWeather");
        }
        return null;
    }

    private WeatherData getWeatherFromWeatherStack(String location) {
        String apiUrl = "http://api.weatherstack.com/current?access_key=" + WEATHER_STACK_API_KEY + "&query=" + location;
        JSONObject response = APIClient.getJSONResponse(apiUrl);

        if (response != null) {
            double temp = response.getJSONObject("current").getDouble("temperature");
            String condition = response.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);
            RateLimiter.markRequest("WeatherStack");
            return new WeatherData(location, temp, condition, "WeatherStack");
        }
        return null;
    }
}
