package proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import behaviours.IWeatherService;
import models.WeatherData;
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

    public WeatherData getWeatherData() throws Exception {
        // Check from cache

        for (IWeatherService service : weatherServices) {
            try {
                CompletableFuture<WeatherData> dataFuture = service.getWeatherDataByIP();
                WeatherData weatherData = dataFuture.get();

                // Cache the data

                return weatherData;
            } catch (Exception e) {
                System.out.println("Service failed: " + service.getClass().getSimpleName());
            }
        }

        throw new Exception("All weather services failed");
    }
}
