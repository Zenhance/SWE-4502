package Adapter;

public class WeatherStackAdapter {
    @Override
    public Weather getWeather(Location location) throws IOException {
        try {
            return WeatherStackAPI.Get_Weather(location);
        }catch (org.json.JSONException e) {
            System.err.println("Error parsing JSON in WeatherStackAPI: " + e.getMessage());

            return null;
        }
    }
    }
