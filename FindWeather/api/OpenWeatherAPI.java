package api;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpenWeatherAPI {
    private static final String API_KEY = "0e87b701dc735ede819b1fed3ad63aeb";

    public JSONObject getWeatherByIP(double latitude, double longitude) throws Exception {
        String apiUrl = String.format(
                "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=metric&appid=%s",
                latitude, longitude, API_KEY
        );
        return fetchWeatherData(apiUrl);
    }

    public JSONObject getWeatherByCity(String city) throws Exception {
        String apiUrl = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
                city, API_KEY
        );
        return fetchWeatherData(apiUrl);
    }

    private JSONObject fetchWeatherData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new Exception("Failed to fetch data from OpenWeather API");
        }

        Scanner scanner = new Scanner(conn.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        return new JSONObject(response);
    }
}
