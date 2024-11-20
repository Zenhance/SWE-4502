package APIs;

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
            JSONObject jsonObject = new JSONObject(response.body());
            allInfo = new JSONObject(response.body());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public WeatherData parseInfotoWeatherData(){
        try{
            if(allInfo == null){
                throw new RuntimeException("Info not fetched yet");
            }
            JSONObject location = allInfo.getJSONObject("location");
            JSONObject current = allInfo.getJSONObject("current");

            

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }
}