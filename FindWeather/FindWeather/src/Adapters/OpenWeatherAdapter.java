package Adapters;

import Interface.WeatherProvider;

import Models.WeatherData;
import org.json.JSONObject;
import Services.LocationService;

public class OpenWeatherAdapter implements WeatherProvider {

    private static final String API_KEY = "aad8726c991abef5cc7e5ad0030ba60e";

    @Override
    public WeatherData getWeather(String city, double latitude, double longitude) {
        try {
String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?appid=%s&lat=%f&lon=%f",
                    API_KEY, latitude, longitude);

            String response = new LocationService().fetchFromUrl(url);

            JSONObject json = new JSONObject(response);

            String location = json.getString("name");
            double temperature = json.getJSONObject("main").getDouble("temp");
            String conditions = json.getJSONArray("weather").getJSONObject(0).getString("description");

            return new WeatherData(location, "OpenWeatherMap", temperature, conditions);


        } catch (Exception e) {
            System.out.println("Error in OpenWeatherAdapter.getWeather()");
            return null;
        }
    }




}
