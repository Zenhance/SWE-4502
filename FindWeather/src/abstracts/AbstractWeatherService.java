package abstracts;

import java.util.concurrent.CompletableFuture;

import behaviours.IweatherService;
import models.WeatherData;

public class AbstractWeatherService implements IweatherService {

    @Override
    public CompletableFuture<WeatherData> getWeatherDataByIP() throws Exception {
    }

    @Override
    CompletableFuture<WeatherData> getWeatherDataByCity() throws Exception {
    }

}
