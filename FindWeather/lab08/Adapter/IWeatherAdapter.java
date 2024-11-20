package Adapter;

public interface IWeatherAdapter {
    Weather getWeather(Location location) throws IOException, JSONException;
}
