package adapters;

import APIs.openWeatherAPI;
import concreteClasses.utility.StringManager;
import concreteClasses.WeatherData;
import interfaces.IweatherInfoProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OpenWeatherAdapter implements IweatherInfoProvider {
    openWeatherAPI api;
    private JSONObject allInfo;
    public OpenWeatherAdapter(){
        api = new openWeatherAPI("e3dfd49f7917fe082f153b64f7ab41b9");
    }

    public WeatherData getWeatherData(String  location){
        StringManager stringManager = new StringManager();
        allInfo = api.fetchData(stringManager.fillSpaceWithSymbol(location));
        return parseInfotoWeatherData();

    }
    public WeatherData parseInfotoWeatherData(){
        try{
            if(allInfo == null){
                throw new RuntimeException("Info not fetched yet");
            }
            JSONObject coord = allInfo.getJSONObject("coord");
            JSONObject main = allInfo.getJSONObject("main");
            JSONArray weatherArray = allInfo.getJSONArray("weather");
            JSONObject weather = weatherArray.getJSONObject(0); // First element in the array

            String cityName = allInfo.getString("name");
            String weatherCondition = weather.getString("description");
            String dataSource = "OpenWeatherMap"; // Updated data source
            double latitude = coord.getDouble("lat");
            double longitude = coord.getDouble("lon");
            double temp = main.getDouble("temp"); // Temperature in Kelvin
            long dt = allInfo.getLong("dt");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Dhaka"));

            String fetchedTime = formatter.format(Instant.ofEpochSecond(dt));
            return new WeatherData(cityName,latitude,longitude,temp-273.15,weatherCondition,dataSource, fetchedTime);

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
