package api;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherStackAPI {
    private static final String API_KEY = "f1177d07fc4272ae4bbccb419a699e91";
    public JSONObject getWeatherByCity(String city) throws Exception {
        String apiUrl = String.format(
                "http://api.weatherstack.com/current?access_key=%s&query=%s",
                API_KEY, city
        );
        return fetchWeatherData(apiUrl);
    }
    public JSONObject getWeatherByIP(double latitude, double longitude) throws Exception {
        String apiUrl = String.format(
                "http://api.weatherstack.com/current?access_key=%s&query=%f,%f",
                API_KEY, latitude, longitude
        );

        return fetchWeatherData(apiUrl);
    }
    private JSONObject fetchWeatherData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new Exception("Failed to get weather data from WeatherStack API");
        }

        Scanner scanner = new Scanner(conn.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        // Debug: Print the API response
        System.out.println("API Response: " + response);

        return new JSONObject(response);
    }

}
