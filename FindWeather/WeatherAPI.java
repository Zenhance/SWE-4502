package APIs;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherAPI {
    private String apiKey;
    private String endpointUrl;
    private JSONObject apiResponse;

    public WeatherAPI(String key) {
        apiKey = key;
        endpointUrl = "https://api.openweathermap.org/data/2.5/weather";
    }