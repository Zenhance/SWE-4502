package com.findweather;

import com.findweather.models.Location;
import org.json.JSONObject;

public class LocationService {
    private static final String IP_STACK_API_KEY = "b71d442b7e89372c15e566abdffb39eb";

    public Location getLocationByIP() {
        try {
            String ip = APIClient.getPublicIP();
            String apiUrl = "http://api.ipstack.com/" + ip + "?access_key=" + IP_STACK_API_KEY;
            JSONObject response = APIClient.getJSONResponse(apiUrl);
            if (response != null) {
                String city = response.getString("city");
                double lat = response.getDouble("latitude");
                double lon = response.getDouble("longitude");
                System.out.println("Detected Location: " + city);
                return new Location(city, lat, lon);
            }
        } catch (Exception e) {
            System.out.println("Error detecting location: " + e.getMessage());
        }
        return null;
    }
}
