package WeatherAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class weatherAPIUtil {
    public static String getResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("HTTP response code: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();

    }
}
