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
        return getIPFromDevice().thenCompose(ip -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(GEOLOCATION_URL + ip))
                    .build();

            CompletableFuture<LocationData> future = new CompletableFuture<>();
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                future.complete(parseLocationData(response.body()));
            } catch (Exception e) {
                future.completeExceptionally(e);
            }

            return future;
        });
    }

    private CompletableFuture<String> getIPFromDevice() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(IPIFY_URL))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return CompletableFuture.completedFuture(response.body());
        } catch (Exception e) {
            CompletableFuture<String> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    // {"status":"success","country":"Bangladesh","countryCode":"BD","region":"C","regionName":"Dhaka
    // Division","city":"Dhaka","zip":"1000","lat":23.7272,"lon":90.4093,"timezone":"Asia/Dhaka","isp":"Axiata
    // (Bangladesh) Limited","org":"Robi Axiata Limited","as":"AS24432 TM
    // International Bangladesh Ltd.Internet service
    // Provider,Gulshan-1,Dhaka-1212","query":"202.134.10.135"}

    private LocationData parseLocationData(String jsonBody) {
        String country = jsonBody.split(",")[1].split(":")[1].replace("\"", "");
        String city = jsonBody.split(",")[5].split(":")[1].replace("\"", "");
        String lat = jsonBody.split(",")[7].split(":")[1].replace("\"", "");
        String lon = jsonBody.split(",")[8].split(":")[1].replace("\"", "");

        return new LocationData(country, city, lat, lon);
    }
}
