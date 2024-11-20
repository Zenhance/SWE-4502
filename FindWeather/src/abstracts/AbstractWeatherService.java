package abstracts;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

import behaviours.IweatherService;
import models.WeatherData;
import services.LocationService;

public class AbstractWeatherService implements IweatherService {
    protected final String API_Key;
    protected LocationService locationService;
    protected HttpClient httpClient;

    @Override
    public CompletableFuture<WeatherData> getWeatherDataByIP() throws Exception {
    }

    @Override
    CompletableFuture<WeatherData> getWeatherDataByCity() throws Exception {
    }

}
