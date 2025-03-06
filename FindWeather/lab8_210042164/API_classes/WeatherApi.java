package lab8_210042164.API_classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApi {
    public static String getResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();
    }
    public static String extractValue(String response, String startKey, String endKey)
    {
        int startIndex = response.indexOf(startKey);
        if (startIndex == -1) return "N/A";
        startIndex += startKey.length();

        int endIndex = response.indexOf(endKey, startIndex);
        if (endIndex == -1) return "N/A";

        return response.substring(startIndex, endIndex);
    }
}
