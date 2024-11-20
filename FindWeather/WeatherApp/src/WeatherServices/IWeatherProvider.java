package WeatherServices;

import Models.WeatherData;

public interface IWeatherProvider {
    public WeatherData getWeatherData(String location);
}
