package WeatherAPI;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import Model.Weather;
import Model.Location;

public class WeatherStackAPI
{
    private static final String WeatherStack_API_KEY="2e980aab13ac4d92aa70e13237f89212";
    public static Weather Get_Weather(Location location) throws IOException
    {
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

            return new Weather(temperature,weatherCondition,location,"WeatherStack");
    }

}
