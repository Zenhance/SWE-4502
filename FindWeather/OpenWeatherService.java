import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OpenWeatherService implements WeatherService {
    private static final String API_KEY = "ded1cb72556aa5f48fae0796135ff11c";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Override
    public WeatherData getWeatherByIP(String ip) throws IOException {

        Location location = getLocationByIP(ip);
        if (location == null) {
            throw new IOException("Unable to determine location from IP.");
        }

        return getWeather(location.getLatitude(), location.getLongitude(), location.getCity());
    }

    @Override
    public WeatherData getWeatherByCity(String city) throws IOException {
        String endpoint = String.format("%s?q=%s&units=metric&appid=%s", BASE_URL, city, API_KEY);
        return fetchWeatherData(endpoint, city);
    }

    private WeatherData getWeather(double latitude, double longitude, String city) throws IOException {
        String endpoint = String.format("%s?lat=%f&lon=%f&units=metric&appid=%s", BASE_URL, latitude, longitude, API_KEY);
        return fetchWeatherData(endpoint, city);
    }




}
