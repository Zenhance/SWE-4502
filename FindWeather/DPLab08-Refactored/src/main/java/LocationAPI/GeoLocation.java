package LocationAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoLocation {
    private static final String GET_URL = "http://api.weatherstack.com/current?access_key=";
    private static final String WEATHERSTACK_API_KEY = "23be6ddf45a59d7958e26dd3e1fb3e77";

    String urlString = GET_URL + WEATHERSTACK_API_KEY + "&query=" + city;
    URL url = new URL(urlString);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    StringBuilder response = new StringBuilder();

    String line;
        while ((line = reader.readLine()) != null) {
        response.append(line);
    }   reader.close();




}
