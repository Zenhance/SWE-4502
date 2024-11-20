import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class OpenWeatherAdapter {

    static final String API_KEY = "8acfb2dc2093a884843a89daab67f4ad";

    public WeatherData getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + API_KEY;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            String temp = json.get("main").getAsJsonObject().get("temp").getAsString();
            String condition = json.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
            return new WeatherData(temp, condition, "OpenWeather");
        } catch (Exception e) {
            System.out.println("OpenWeather error: " + e.getMessage());
            return null;
        }
    }
}


        }
