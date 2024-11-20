package Adapter;
import Model.Location;
import Model.Weather;
import org.json.JSONException;

import java.io.IOException;

public interface IWeatherAdapter {
    Weather getWeather(Location location) throws IOException, JSONException;
}
