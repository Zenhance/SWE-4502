package Adapters;

import Interface.WeatherProvider;
import Models.WeatherData;

public class WeatherStackAdapter implements WeatherProvider {

    private static final String API_Key="dfa082b6e772662f7041fc5f8370e72d";

    @Override
    public WeatherData getWeather(String city, double latitude, double longitude) {

        return null;

    }

}
