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