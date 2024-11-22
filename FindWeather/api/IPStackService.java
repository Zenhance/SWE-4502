package api;

import models.Location;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IPStackService {
    private static final String API_KEY = "672a2c4fe1dd4739cf51e155cec02b4f";
    public Location getLocationByIP() throws Exception {
        String apiUrl = "http://api.ipstack.com/check?access_key=" + API_KEY;

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() != 200) {
            throw new Exception("Failed to get location from IPStack API");
        }

        Scanner scanner = new Scanner(conn.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        JSONObject jsonResponse = new JSONObject(response);
        String city = jsonResponse.optString("city", "Unknown");
        double latitude = jsonResponse.getDouble("latitude");
        double longitude = jsonResponse.getDouble("longitude");

        return new Location(city, latitude, longitude);
    }
}
