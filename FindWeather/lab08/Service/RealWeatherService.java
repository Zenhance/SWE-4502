
package Service;

import Adapter.IWeatherAdapter;
import Adapter.OpenWeatherAdapter;
import Adapter.WeatherStackAdapter;
import Model.Location;
import Model.Weather;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;








public class RealWeatherService implements IWeatherService {
    public static boolean useWeatherStack = true;
    private static LocalDateTime lastApiCallTime;

    private final IWeatherAdapter weatherStackAdapter;
    private final IWeatherAdapter openWeatherAdapter;

    public RealWeatherService() {
        this.weatherStackAdapter = new WeatherStackAdapter();
        this.openWeatherAdapter = new OpenWeatherAdapter();
    }

    @Override
    public Weather getWeather(Location location) throws IOException {
        if (lastApiCallTime != null && Duration.between(lastApiCallTime, LocalDateTime.now()).getSeconds() < 30) {
            useWeatherStack = !useWeatherStack;
        }
        lastApiCallTime = LocalDateTime.now();

        try {
            if (useWeatherStack) {
                return weatherStackAdapter.getWeather(location);
            } else {
                return openWeatherAdapter.getWeather(location);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }



    }