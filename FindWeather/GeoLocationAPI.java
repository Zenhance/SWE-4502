package APIs;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeoLocationAPI {
    private String apiKey;
    private String baseUrl;

    public GeoLocationAPI(String key) {
        apiKey = key; // Example key: "355dbc2e06a2a5956bc522f5a7d1ca21"
        baseUrl = "https://api.ipstack.com/";
    }

     public JSONObject retrieveData(String ipAddress) {
        String fullUrl = baseUrl + ipAddress + "?access_key=" + apiKey;

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(fullUrl))
                    .build();

                    HttpResponse<String> httpResponse =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new JSONObject(httpResponse.body());