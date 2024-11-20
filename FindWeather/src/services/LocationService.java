package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import behaviours.ILocationService;
import models.LocationData;

public class LocationService implements ILocationService {
    private final String IPIFY_URL = "https://api.ipify.org/";
    private final String GEOLOCATION_URL = "http://ip-api.com/json/";
    private HttpClient httpClient;

    public LocationService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public CompletableFuture<LocationData> getLocationData() {

    }

    private CompletableFuture<String> getIP() {

    }

    private LocationData parseLocationData(String jsonBody) {

    }
}
