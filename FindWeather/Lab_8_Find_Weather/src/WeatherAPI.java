import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI
{
    private static final String WeatherStack_API_KEY="2e980aab13ac4d92aa70e13237f89212";
    public static Weather Get_Weather(Location location) throws IOException {
        try {
            //http://api.weatherstack.com/current
            //    ? access_key = 2e980aab13ac4d92aa70e13237f89212
            //    & query = New York
            String urlString = "http://api.weatherstack.com/current?access_key=" + WeatherStack_API_KEY + "&query=" + location.getCity();
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

            JSONObject jsonObject=new JSONObject(response.toString());

            double temperature=jsonObject.getJSONObject("current").getDouble("temperature");

            String weatherCondition=jsonObject.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);

            return new Weather(temperature,weatherCondition,location);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;

        }

    }
//    private static final String OpenWeather_API_KEY="5365b62035ea68a88463c7539f20fb67";
//
//    public static Weather Get_Weather(Location location) throws IOException {
//        try {
//            // API endpoint: http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric
//            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location.getCity() + "&appid=" + OpenWeather_API_KEY + "&units=metric";
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder response = new StringBuilder();
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            JSONObject jsonObject = new JSONObject(response.toString());
//
//            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
//            String weatherCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
//
//            return new Weather(temperature, weatherCondition, location);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
