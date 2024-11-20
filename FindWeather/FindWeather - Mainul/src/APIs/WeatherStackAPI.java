package APIs;

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

public class WeatherStackAPI {
    private String api_key;
    private String base_url;
    private JSONObject allInfo;

    public WeatherStackAPI() {
        api_key = "4c31a3c95ae754203e58d51a39643e4b";
        base_url = "http://api.weatherstack.com/current";
    }

    public void fetchAPI(String location) throws IOException, InterruptedException {
        String ChangedLocation = "";
        for (char ch : location.toCharArray()) {
            if (ch != ' ') {
                ChangedLocation += ch;
            } else {
                ChangedLocation += "%20";
            }
        }
        String url = base_url + "?access_key=" + api_key + "&query=" + ChangedLocation;
        try {


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
            JSONObject jsonObject = new JSONObject(response.body());
            allInfo = new JSONObject(response.body());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public void printWeatherDescription(){
        System.out.println(allInfo);
    }
}