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
        api.fetchAPI(stringManager.fillSpaceWithSymbol(location));
        return parseInfotoWeatherData();

    }
