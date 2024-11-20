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

    }
