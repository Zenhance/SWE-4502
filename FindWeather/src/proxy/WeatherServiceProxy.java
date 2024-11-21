package proxy;

import java.util.ArrayList;
import java.util.List;

import behaviours.IWeatherService;
import services.OpenWeatherService;
import services.WeatherStackService;

public class WeatherServiceProxy {

    private List<IWeatherService> weatherServices;

    public WeatherServiceProxy() {
        this.weatherServices = new ArrayList<>();
        this.weatherServices.add(new OpenWeatherService());
        this.weatherServices.add(new WeatherStackService());
    }

    public void addWeatherService(IWeatherService service) {
        weatherServices.add(service);
    }
}
