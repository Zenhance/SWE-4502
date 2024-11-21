package adapters;

import APIs.openWeatherAPI;
import concreteClasses.utility.StringManager;
import concreteClasses.WeatherData;
import interfaces.IweatherInfoProvider;
import org.json.JSONArray;
import org.json.JSONObject;

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

            return new WeatherData(cityName,latitude,longitude,temp,weatherCondition,dataSource);

        }
        catch (Exception e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
