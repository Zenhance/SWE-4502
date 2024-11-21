package behaviours;

import java.util.concurrent.CompletableFuture;

import models.WeatherData;

public interface IWeatherService {
    CompletableFuture<WeatherData> getWeatherDataByIP() throws Exception;

    CompletableFuture<WeatherData> getWeatherDataByCity() throws Exception;
}
