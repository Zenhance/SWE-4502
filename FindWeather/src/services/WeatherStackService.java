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

    // {"request":{"type":"City","query":"Tongi,
    // Bangladesh","language":"en","unit":"m"},"location":{"name":"Tongi","country":"Bangladesh","region":"","lat":"23.890","lon":"90.406","timezone_id":"Asia\/Dhaka","localtime":"2024-11-15
    // 20:49","localtime_epoch":1731703740,"utc_offset":"6.0"},"current":{"observation_time":"02:49
    // PM","temperature":24,"weather_code":113,"weather_icons":["https:\/\/cdn.worldweatheronline.com\/images\/wsymbols01_png_64\/wsymbol_0008_clear_sky_night.png"],"weather_descriptions":["Clear
    // "],"wind_speed":12,"wind_degree":330,"wind_dir":"NNW","pressure":1011,"precip":0,"humidity":57,"cloudcover":0,"feelslike":25,"uv_index":0,"visibility":10,"is_day":"no"}}
    @Override
    protected WeatherData parseWeatherResponse(String jsonBody) {
        String location = jsonBody.split("\"name\":\"")[1].split("\"")[0];
        double temperature = Double.parseDouble(jsonBody.split("\"temperature\":")[1].split(",")[0]);
        String weatherDescription = jsonBody.split("\"weather_descriptions\":\\[\"")[1].split("\"")[0];

        return new WeatherData(temperature, weatherDescription, location, "WeatherStack");
    }
}
