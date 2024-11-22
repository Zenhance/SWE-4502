import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GeoLocation {
    private static final String GET_URL = "http://api.weatherstack.com/current?access_key=";
    private static final String WEATHERSTACK_API_KEY = "rt34q1f45a59d7958e26dd3e1gh0e9";
    public static Location get_Location_by_city(String city) throws IOException, JSONException {
        String urlString = GET_URL + WEATHERSTACK_API_KEY + "&query=" + city;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        
    }

}