package Adapters;

import Interface.WeatherProvider;
import Models.WeatherData;
import Services.LocationService;
import org.json.JSONObject;

public class WeatherStackAdapter implements WeatherProvider {

    private static final String API_Key = "dfa082b6e772662f7041fc5f8370e72d";

    @Override
    public WeatherData getWeather(String city, double latitude, double longitude) {

        try {
            String url = String.format(
                    "http://api.weatherstack.com/current?access_key=%s&query=%s",
                    API_Key, city);



            String response = new LocationService().fetchFromUrl(url);

            JSONObject json = new JSONObject(response);
            double temp= json.getJSONObject("current").getDouble("temperature");
            String condition= json.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);

            return new WeatherData(city, "WeatherStack", temp, condition);

        } catch (Exception e) {
            System.out.println("Error in WeatherStackAdapter.getWeather()");
            return null;
        }


    }


}
