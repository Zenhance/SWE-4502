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
     private final String GEOCODING_URL = "http://api.openweathermap.org/geo/1.0/direct";
    private final String API_KEY = "e3c9bf35e426c1789775f45994cc305c";
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


    public CompletableFuture<LocationData> getLocationDataByCity(String cityName) {
        String encodedCityName = java.net.URLEncoder.encode(cityName, java.nio.charset.StandardCharsets.UTF_8);
        String requestUrl = GEOCODING_URL + "?q=" + encodedCityName + "&limit=1&appid=" + API_KEY;
        
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();
        
        CompletableFuture<LocationData> future = new CompletableFuture<>();
        
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            future.complete(parseGeoLocationData(response.body(), cityName));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        
        return future;
    }

    private LocationData parseGeoLocationData(String jsonBody, String cityName) {

        if (jsonBody.equals("[]")) {
            throw new RuntimeException("City not found: " + cityName);
        }
    
        String name = findValue(jsonBody, "\"name\":\"", "\"");
        String country = findValue(jsonBody, "\"country\":\"", "\"");
        String lat = findValue(jsonBody, "\"lat\":", ",");
        String lon = findValue(jsonBody, "\"lon\":", ",");
        
        if (lon.isEmpty()) {
            lon = findValue(jsonBody, "\"lon\":", "}");
        }
        
        if (name.isEmpty()) {
            name = cityName;
        }
        
        return new LocationData(country, name, lat, lon);
    }

    private String findValue(String json, String prefix, String suffix) {
        
        int start = json.indexOf(prefix);
        if (start == -1) return "";
        
        start += prefix.length();
        int end = json.indexOf(suffix, start);
        if (end == -1) return "";
        
        return json.substring(start, end);
    }
}
