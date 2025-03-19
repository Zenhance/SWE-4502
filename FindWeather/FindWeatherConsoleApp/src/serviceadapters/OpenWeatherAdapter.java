package serviceadapters;

import behaviours.IWeatherService;
import datamodels.LocationData;
import datamodels.WeatherData;
import org.json.JSONObject;
import utils.RequestResponseHandler;

public class OpenWeatherAdapter implements IWeatherService {

    private static final String api_key = "2930e21f83f6a5aac4efcc9061f34e40";
    private static final String base_url = "http://api.openweathermap.org/data/2.5/weather";

    @Override
    public WeatherData getWeatherDataByCity(String city) throws Exception {
        String url = base_url + "?q=" + city + "&appid=" + api_key + "&units=metric";
        return fetchData(url);
    }

    @Override
    public WeatherData getWeatherDataByIP() throws Exception {
        LocationServiceAdapter locationServiceAdapter = new LocationServiceAdapter();
        LocationData locationData = locationServiceAdapter.getLocationData();

        String url = base_url + "?lat=" + locationData.getLatitude() +
                "&lon=" + locationData.getLongitude() +
                "&appid=" + api_key + "&units=metric";
        return fetchData(url);
    }

    private WeatherData fetchData(String url) throws Exception {
        String response = RequestResponseHandler.sendGetRequest(url);
        JSONObject jsonObject = new JSONObject(response);


        JSONObject location = jsonObject.getJSONObject("coord");
        double latitude = location.getDouble("lat");
        double longitude = location.getDouble("lon");
        String city = jsonObject.getString("name");
        String country = jsonObject.getJSONObject("sys").getString("country");


        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");

        String weatherCondition = jsonObject.getJSONArray("weather")
                .getJSONObject(0)
                .getString("description");

        return new WeatherData(
                temperature,
                weatherCondition,
                new LocationData(city, country, latitude, longitude),
                "OpenWeather"
        );
    }
}

