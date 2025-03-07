package behaviours;

import datamodels.WeatherData;

public interface IWeatherService {
    public WeatherData getWeatherData() throws Exception;
}
