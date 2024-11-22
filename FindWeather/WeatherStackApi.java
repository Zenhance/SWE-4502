

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class WeatherStackAPI {
    private static final String WeatherStack_API_KEY = "5e013aab13ac4d92aa70e32137f90102";

    public static Weather Get_Weather(Location location) throws IOException, JSONException {
        String urlString = "http://api.weatherstack.com/current?access_key=" + WeatherStack_API_KEY + "&query=" + location.getCity();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        double temp = jsonObject.getJSONObject("current").getDouble("temperature");
        String weather = jsonObject.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);
        return new Weather(temp, weather, location, "WeatherStack");
    }
}