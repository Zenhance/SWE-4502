package WeatherService;
import Model.Location;
import Model.Weather;
import WeatherAPI.OpenWeatherAPI;
import WeatherAPI.WeatherStackAPI;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class RealWeatherService implements IWeatherService
{
    private static boolean useWeatherStack = true;
    private static LocalDateTime lastApiCallTime;

    @Override
    public Weather getWeather(Location location) throws IOException
    {
        if (lastApiCallTime != null && Duration.between(lastApiCallTime, LocalDateTime.now()).getSeconds() < 30)
        {
            useWeatherStack = !useWeatherStack;
        }

        lastApiCallTime = LocalDateTime.now();

        if (useWeatherStack)
        {
            return WeatherStackAPI.Get_Weather(location);
        }

        else
        {
            return OpenWeatherAPI.Get_Weather(location);
        }
    }
}
