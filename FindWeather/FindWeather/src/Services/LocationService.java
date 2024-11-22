package Services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import Models.Location;
import org.json.JSONObject;

public class LocationService {
    private static final String IP_STACK_API_KEY = "3c740c9352fb4b00453b0d0dd1159e51";
    private static final String IPIFY_URL = "https://api.ipify.org?format=json";

    public Location getLocationByIP() {
        try {
            String ip = fetchIP();
            if (ip == null) return null;

            String url = "http://api.ipstack.com/" + ip + "?access_key=" + IP_STACK_API_KEY;
            String response = fetchFromUrl(url);

            JSONObject json = new JSONObject(response);
            String city = json.optString("city");
            double latitude = json.optDouble("latitude");
            double longitude = json.optDouble("longitude");

            return new Location(city, latitude, longitude);
        } catch (IOException e) {
            System.out.println("Failed to detect location by IP: " + e.getMessage());
            return null;
        }
    }

    public Location getLocationByCity(String city) {
        String url = String.format("http://api.ipstack.com/%s?access_key=%s",
                city.replace(" ", "%20"), IP_STACK_API_KEY);

        try {
            // Fetch data from IP Stack API
            String response = fetchFromUrl(url);
            JSONObject json = new JSONObject(response);

            // Check if the city is found in the response
            if (json.has("city") && json.has("latitude") && json.has("longitude")) {
                String resolvedCity = json.getString("city");
                double latitude = json.getDouble("latitude");
                double longitude = json.getDouble("longitude");

                // Return location object
                return new Location(resolvedCity, latitude, longitude);
            } else {
                System.out.println("City not found.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error fetching location data: " + e.getMessage());
            return null;
        }
    }

    private String fetchIP() throws IOException {
        String response = fetchFromUrl(IPIFY_URL);
        JSONObject json = new JSONObject(response);
        return json.optString("ip");
    }

    private String fetchFromUrl(String urlString) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
        conn.setRequestMethod("GET");

        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            return response.toString();
        }
    }
}
