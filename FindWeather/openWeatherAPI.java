package APIs;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class openWeatherAPI {
    private String api_key;
    private String base_url;
    private JSONObject allInfo;
    public openWeatherAPI(String _api_key){
        api_key = _api_key;
        base_url = "https://api.openweathermap.org/data/2.5/weather";
    }