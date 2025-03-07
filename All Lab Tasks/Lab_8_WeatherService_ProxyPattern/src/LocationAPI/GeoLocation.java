package LocationAPI;

import Model.Location;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoLocation
{
    private static final String GET_URL="http://api.weatherstack.com/current?access_key=";
    private static final String WEATHERSTACK_API_KEY = "2e980aab13ac4d92aa70e13237f89212";

    public static Location get_Location_by_city(String city) throws IOException {
        String urlString=GET_URL + WEATHERSTACK_API_KEY + "&query=" + city;
        URL url=new URL(urlString);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        //JSONObject location = jsonObject.getJSONObject("location");

        double latitude = jsonObject.getJSONObject("location").getDouble("lat");
        double longitude = jsonObject.getJSONObject("location").getDouble("lon");

        return new Location(city, latitude, longitude);

    }

}

