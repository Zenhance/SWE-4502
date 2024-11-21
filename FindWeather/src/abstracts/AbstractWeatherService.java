package abstracts;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import behaviours.IWeatherService;
import models.LocationData;
import models.WeatherData;
import services.LocationService;

public abstract class AbstractWeatherService implements IWeatherService {
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
        CompletableFuture<LocationData> locationFuture = locationService.getLocationData();
        LocationData locationData = locationFuture.get();

        String requestUrl = buildRequestUrl(locationData);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return CompletableFuture.completedFuture(parseWeatherResponse(response.body()));
        } catch (Exception e) {
            CompletableFuture<WeatherData> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    @Override
    public CompletableFuture<WeatherData> getWeatherDataByCity() throws Exception {
        // TODO: Implement this method

        return null;
    }

    protected abstract String buildRequestUrl(LocationData locationData);

    protected abstract WeatherData parseWeatherResponse(String jsonBody);
}
