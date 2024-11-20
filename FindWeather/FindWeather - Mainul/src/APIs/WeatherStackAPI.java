package APIs;

import concreteClasses.StringManager;
import concreteClasses.WeatherData;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static java.net.http.HttpClient.newHttpClient;

public class WeatherStackAPI {
    private String api_key;
    private String base_url;
    private JSONObject allInfo;

    public WeatherStackAPI(String _api_key) {
        api_key = _api_key;
        base_url = "http://api.weatherstack.com/current";
    }
    public JSONObject fetchAPI(String location)  {

        String url = base_url + "?access_key=" + api_key + "&query=" + location;
        try {
            HttpClient client = newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            allInfo = new JSONObject(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }



}