import org.json.simple.JSONObject;

public interface WeatherService {
    JSONObject getLocation(String city);
    void displayWeather(double latitude, double longitude);
}
