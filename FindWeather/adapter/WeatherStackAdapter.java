package adapter;
import api.WeatherStackAPI;
import models.WeatherData;
import org.json.JSONObject;

public class WeatherStackAdapter implements WeatherProvider{
    private final WeatherStackAPI api;
    public WeatherStackAdapter() {
        this.api = new WeatherStackAPI();
    }
    @Override
    public WeatherData getWeatherByCity(String city) throws Exception {
        JSONObject response = api.getWeatherByCity(city);

        if (!response.has("current")) {
            throw new Exception("Weather data not available for the city: " + city);
        }

        JSONObject current = response.getJSONObject("current");
        double temperature = current.getDouble("temperature");
        String conditions = current.getJSONArray("weather_descriptions").getString(0);

        return new WeatherData(city, temperature, conditions, "WeatherStack");
    }

    @Override
    public WeatherData getWeatherByIP(double latitude, double longitude) throws Exception {
        JSONObject response = api.getWeatherByIP(latitude, longitude);
        double temperature = response.getJSONObject("current").getDouble("temperature");
        String conditions = response.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);

        return new WeatherData("Location via IP", temperature, conditions, "WeatherStack");
    }
}
