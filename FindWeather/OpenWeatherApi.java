import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherAPI {

        private static final String OpenWeather_API_KEY = "23be6ddf45a59d7958e26dd3e1fb3e77";

        public static Weather Get_Weather(Location location) throws IOException, JSONException {
            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location.getCity() + "&appid=" + OpenWeather_API_KEY + "&units=metric";
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

            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
            String weatherCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

            return new Weather(temperature, weatherCondition, location, "OpenWeather");
        }
    }