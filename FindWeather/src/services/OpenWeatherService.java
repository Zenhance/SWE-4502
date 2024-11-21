package services;

import java.text.MessageFormat;

import abstracts.AbstractWeatherService;
import models.LocationData;
import models.WeatherData;

public class OpenWeatherService extends AbstractWeatherService {
    private final static String OPEN_WEATHER_MAP_API_KEY = "e3c9bf35e426c1789775f45994cc305c";
    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?lat={0}&lon={1}&units=metric&appid={2}";

    public OpenWeatherService() {
        super(OPEN_WEATHER_MAP_API_KEY);
    }

    @Override
    protected String buildRequestUrl(LocationData locationData) {

    }

    // {"coord":{"lon":90.4023,"lat":23.8915},"weather":[{"id":721,"main":"Haze","description":"haze","icon":"50n"}],"base":"stations","main":{"temp":25,"feels_like":25.36,"temp_min":25,"temp_max":25,"pressure":1012,"humidity":69,"sea_level":1012,"grnd_level":1011},"visibility":3200,"wind":{"speed":1.54,"deg":260},"clouds":{"all":40},"dt":1731685022,"sys":{"type":1,"id":9145,"country":"BD","sunrise":1731629603,"sunset":1731669170},"timezone":21600,"id":1185098,"name":"Tongi","cod":200}
    @Override
    protected WeatherData parseWeatherResponse(String jsonBody) {

    }
}
