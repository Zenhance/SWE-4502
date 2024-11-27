package adapters;

import APIs.WeatherStackAPI;
import concreteClasses.utility.StringManager;
import concreteClasses.WeatherData;
import interfaces.IweatherInfoProvider;
import org.json.JSONObject;

public class WeatherStackAdapter implements IweatherInfoProvider {
    private JSONObject allInfo;
    private WeatherStackAPI api;
    public  WeatherStackAdapter(){
        api = new WeatherStackAPI("4c31a3c95ae754203e58d51a39643e4b");
    }

    public WeatherData getWeatherData(String  location){
        StringManager stringManager = new StringManager();
        allInfo = api.fetchAPI(stringManager.fillSpaceWithSymbol(location));
        return parseInfotoWeatherData();

    }
    private WeatherData parseInfotoWeatherData(){
        try{
            if(allInfo == null){
                throw new RuntimeException("Info not fetched yet");
            }
            JSONObject location = allInfo.getJSONObject("location");
            JSONObject current = allInfo.getJSONObject("current");

            String cityName = location.getString("name");
            String weatherCondition = current.getJSONArray("weather_descriptions").getString(0);
            String dataSource = "WeatherStack";
            double latitude = location.getDouble("lat");
            double longitude = location.getDouble("lon");
            double temp = current.getDouble("temperature");
            String localtime = allInfo.getJSONObject("location").getString("localtime");
            return new WeatherData(cityName,latitude,longitude,temp,weatherCondition,dataSource, localtime);

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
