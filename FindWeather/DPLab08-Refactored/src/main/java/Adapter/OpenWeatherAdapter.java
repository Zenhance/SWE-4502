package Adapter;


import Model.Location;
import Model.Weather;
import WeatherAPI.OpenWeatherAPI;
import org.json.JSONException;

import java.io.IOException;

public class OpenWeatherAdapter implements IWeatherAdapter {

    @Override
    public Weather getWeather(Location location) throws IOException ,JSONException {
        return OpenWeatherAPI.Get_Weather(location);
    }
}
