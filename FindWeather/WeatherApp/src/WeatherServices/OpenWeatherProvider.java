package WeatherServices;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Models.WeatherData;
import org.json.simple.JSONArray;

public class OpenWeatherProvider implements IWeatherProvider {
    String ApiKey = "8b2131d2c1d531dd655dde21ebfc3984";
    String BaseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
    

    public WeatherData getWeatherData(String location){
        String Url = BaseUrl + location + "&appid=" + ApiKey;
        // need to call api and get response
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(Url))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		
        try {
            HttpClient client = HttpClient.newHttpClient();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            WeatherData weatherData = null;

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.body());

            if (jsonResponse.containsKey("main") && jsonResponse.containsKey("weather")) {
                
                JSONObject main = (JSONObject) jsonResponse.get("main");
                double temperature = (double) main.get("temp");
                // Kelvin to Celcius
                temperature -= 273.15;

                
                JSONArray weatherArray = (JSONArray) jsonResponse.get("weather");
                String conditions = ((JSONObject) weatherArray.get(0)).get("description").toString();
                String locationInformation = jsonResponse.get("name").toString(); // Location name

            
                weatherData = new WeatherData(String.valueOf(temperature), conditions, locationInformation, "OpenWeather");
                
                return weatherData;
            } else {
                System.out.println("Invalid response structure: " + jsonResponse);
            }
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
