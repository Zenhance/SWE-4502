package services;

import java.text.MessageFormat;

import abstracts.AbstractWeatherService;
import models.LocationData;
import models.WeatherData;

public class WeatherStackService extends AbstractWeatherService {
    private static final String WEATHERSTACK_API_KEY = "b241366e762063ba924efb466bb650d9";
    private final String API_URL = "http://api.weatherstack.com/current?access_key={0}&query={1}&units=m";

    public WeatherStackService() {
        super(WEATHERSTACK_API_KEY);
    }

    @Override
    protected String buildRequestUrl(LocationData locationData) {
        return MessageFormat.format(
                API_URL,
                WEATHERSTACK_API_KEY,
                locationData.getCity());
    }

    @Override
    protected WeatherData parseWeatherResponse(String jsonBody) {
    }
}
