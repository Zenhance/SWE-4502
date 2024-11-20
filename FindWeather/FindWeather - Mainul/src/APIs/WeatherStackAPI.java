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

    public WeatherStackAPI() {
        api_key = "4c31a3c95ae754203e58d51a39643e4b";
        base_url = "http://api.weatherstack.com/current";
    }
    public WeatherData getWeatherData(String  location){
        StringManager stringManager = new StringManager();
        fetchAPI(stringManager.fillSpaceWithSymbol(location));
        return parseInfotoWeatherData();

    }
    private void fetchAPI(String location)  {

        String url = base_url + "?access_key=" + api_key + "&query=" + location;
        try {


            HttpClient client = newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body());
            allInfo = new JSONObject(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }


    private WeatherData parseInfotoWeatherData(){
        try{
            if(allInfo == null){
                throw new RuntimeException("Info not fetched yet");
            }
            JSONObject location = allInfo.getJSONObject("location");
            JSONObject current = allInfo.getJSONObject("current");

            String cityName = location.getString("name");
            String weatherCondition = location.getString("weather_descriptions");
            String dataSource = location.getString("WeatherStack");
            double latitude = location.getDouble("lat");
            double longitude = location.getDouble("lon");
            double temp = location.getDouble("temperature");

            return new WeatherData(cityName,latitude,longitude,temp,weatherCondition,dataSource);

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}