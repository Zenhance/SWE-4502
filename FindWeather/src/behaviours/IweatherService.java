package behaviours;

import java.util.concurrent.CompletableFuture;

import models.WeatherData;

public interface IweatherService {
    CompletableFuture<WeatherData> getWeatherData() throws Exception;
}
