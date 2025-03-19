package behaviours;

import datamodels.WeatherData;

public interface IWeatherService {
    public WeatherData getWeatherDataByCity(String city) throws Exception;

    public WeatherData getWeatherDataByIP() throws Exception;
}
