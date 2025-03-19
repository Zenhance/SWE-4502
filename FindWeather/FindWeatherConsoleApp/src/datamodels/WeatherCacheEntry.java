package datamodels;

import java.time.Instant;

public class WeatherCacheEntry {
    private WeatherData weatherdata;
    private Instant timestamp;

    public WeatherCacheEntry(WeatherData weatherdata)
    {
        this.weatherdata=weatherdata;
        this.timestamp=Instant.now();
    }

    public WeatherData getWeatherData()
    {
        return weatherdata;
    }
    public boolean isExpired()
    {
        return Instant.now().isAfter(timestamp.plusSeconds(600));
    }
}
