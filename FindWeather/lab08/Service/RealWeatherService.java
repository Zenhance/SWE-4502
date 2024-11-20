
package WeatherService;

import Adapter.IWeatherAdapter;
import Adapter.OpenWeatherAdapter;
import Adapter.WeatherStackAdapter;
import Model.Location;
import Model.Weather;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;








public class RealWeatherService implements IWeatherService {