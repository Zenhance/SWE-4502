package abstracts;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

import behaviours.IweatherService;
import models.LocationData;
import models.WeatherData;
import services.LocationService;

public abstract class AbstractWeatherService implements IweatherService {
    protected final String API_Key;
    protected LocationService locationService;
    protected HttpClient httpClient;

    public AbstractWeatherService(String API_Key) {
        this.API_Key = API_Key;
        this.locationService = new LocationService();
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public CompletableFuture<WeatherData> getWeatherDataByIP() throws Exception {
    }

    @Override
    public CompletableFuture<WeatherData> getWeatherDataByCity() throws Exception {
    }

    protected abstract String buildRequestUrl(LocationData locationData);

    protected abstract WeatherData parseWeatherResponse(String jsonBody);
}
