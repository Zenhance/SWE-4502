package com.findweather;

import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIClient {

    public static JSONObject getJSONResponse(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            return new JSONObject(response.toString());
        } catch (Exception e) {
            System.out.println("API Error: " + e.getMessage());
            return null;
        }
    }

    public static String getPublicIP() throws IOException {
        String apiUrl = "https://api.ipify.org?format=json";
        JSONObject response = getJSONResponse(apiUrl);
        return response.getString("ip");
    }
}
