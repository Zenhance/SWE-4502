package Interface;

import Models.WeatherData;

public interface WeatherProvider {
    WeatherData getWeather(String city, double latitude, double longitude);
}
