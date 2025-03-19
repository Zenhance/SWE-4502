package serviceadapters;

import behaviours.IWeatherService;
import datamodels.LocationData;
import datamodels.WeatherData;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.RequestResponseHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherStackAdapter implements IWeatherService {

    private static final String api_key="51d344334c949089bd56e3eb797441d0";

    private static final String base_url="http://api.weatherstack.com/current";
    @Override
    public WeatherData getWeatherDataByCity(String city) throws Exception {

        String url=base_url+"?access_key="+api_key+"&query="+city;

        return fetchData(url);
    }

    @Override
    public WeatherData getWeatherDataByIP() throws Exception {
        LocationServiceAdapter locationServiceAdapter = new LocationServiceAdapter();
        LocationData locationData = locationServiceAdapter.getLocationData();
        String url=base_url+"?access_key="+api_key+"&query="+locationData.getLatitude()+","+locationData.getLongitude();
        return fetchData(url);
    }

    private WeatherData fetchData(String url) throws Exception {
        String response= RequestResponseHandler.sendGetRequest(url);
        JSONObject jsonObject = new JSONObject(response);


        JSONObject location = jsonObject.getJSONObject("location");
        String city = location.getString("name");
        String country = location.getString("country");
        double latitude = location.getDouble("lat");
        double longitude = location.getDouble("lon");

        JSONObject current = jsonObject.getJSONObject("current");
        double temperature = current.getDouble("temperature");
        String weatherCondition = current.getJSONArray("weather_descriptions").getString(0);
        return new WeatherData(temperature,weatherCondition,new LocationData(city,country,latitude,longitude),"WeatherStack");
    }
}
