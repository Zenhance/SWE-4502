package WeatherService;

import Adapter.IWeatherAdapter;
import Adapter.OpenWeatherAdapter;
import Adapter.WeatherStackAdapter;
import Model.Location;
import Model.Weather;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class RealWeatherService {
    public static boolean useWeatherStack = true;
    private static LocalDateTime lastApiCallTime;

    private final IWeatherAdapter weatherStackAdapter;
    private final IWeatherAdapter openWeatherAdapter;

    public RealWeatherService() {
        this.weatherStackAdapter = new WeatherStackAdapter();
        this.openWeatherAdapter = new OpenWeatherAdapter();
    }
}
