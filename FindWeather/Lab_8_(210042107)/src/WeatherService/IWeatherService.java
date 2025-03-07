package WeatherService;

import Model.Location;
import Model.Weather;

import java.io.IOException;

public interface IWeatherService
{
    Weather getWeather(Location location) throws IOException;
}
