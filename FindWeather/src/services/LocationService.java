package services;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

import behaviours.ILocationService;
import models.LocationData;

public class LocationService implements ILocationService {
    private final String IPIFY_URL = "https://api.ipify.org/";
    private final String GEOLOCATION_URL = "http://ip-api.com/json/";
    private HttpClient httpClient;

    @Override
    public CompletableFuture<LocationData> getLocationData() {

    }
}
