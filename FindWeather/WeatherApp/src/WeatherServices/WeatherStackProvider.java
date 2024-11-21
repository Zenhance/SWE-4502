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


public class WeatherStackProvider implements IWeatherProvider {
    private final String ApiKey = "ce4b6d132e608ff12c4bd2724a3e6c64";
    private final String BaseUrl = "http://api.weatherstack.com/current?access_key=";

    @Override
    public WeatherData getWeatherData(String location) {
        String Url = BaseUrl + ApiKey + "&query=" + location;
        // Create an HTTP request to fetch weather data
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            WeatherData weatherData = null;

            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.body());

            if (jsonResponse.containsKey("current") && jsonResponse.containsKey("location")) {
                // Extract weather details
                JSONObject current = (JSONObject) jsonResponse.get("current");
                double temperature = ((Number) current.get("temperature")).doubleValue(); // In Celsius
                String conditions = current.get("weather_descriptions").toString(); // Weather description
                
                // Extract location details
                JSONObject locationData = (JSONObject) jsonResponse.get("location");
                String locationName = locationData.get("name").toString();

                // Create and return WeatherData object
                weatherData = new WeatherData(temperature, conditions, locationName, "WeatherStack");
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
