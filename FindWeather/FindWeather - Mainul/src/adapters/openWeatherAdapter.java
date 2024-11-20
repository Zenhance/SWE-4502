package adapters;

import APIs.WeatherStackAPI;
import APIs.openWeatherAPI;
import concreteClasses.StringManager;
import concreteClasses.WeatherData;
import interfaces.Iweatherprovider;
import org.json.JSONObject;

public class openWeatherAdapter implements Iweatherprovider {
    openWeatherAPI api;
    private JSONObject allInfo;
    public openWeatherAdapter(){
        api = new openWeatherAPI("e3dfd49f7917fe082f153b64f7ab41b9");
    }
    @Override
    public String weather() {
        return "";
    }

    public WeatherData getWeatherData(String  location){
        StringManager stringManager = new StringManager();
        allInfo = api.fetchData(stringManager.fillSpaceWithSymbol(location));
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
            String weatherCondition = location.getString("weather_descriptions");
            String dataSource = location.getString("WeatherStack");
            double latitude = location.getDouble("lat");
            double longitude = location.getDouble("lon");
            double temp = location.getDouble("temperature");

            return new WeatherData(cityName,latitude,longitude,temp,weatherCondition,dataSource);

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
