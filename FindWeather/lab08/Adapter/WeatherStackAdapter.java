package Adapter;

public class WeatherStackAdapter {
    @Override
    public Weather getWeather(Location location) throws IOException {
        try {
            return WeatherStackAPI.Get_Weather(location);
        }
    }
