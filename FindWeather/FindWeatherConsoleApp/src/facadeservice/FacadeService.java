package facadeservice;

import datamodels.LocationData;
import datamodels.WeatherData;
import proxyservice.WeatherServiceProxy;
import serviceadapters.LocationServiceAdapter;

public class FacadeService {
    private final WeatherServiceProxy weatherServiceProxy;

    private final LocationServiceAdapter locationServiceAdapter;

    public FacadeService()
    {
        this.weatherServiceProxy=new WeatherServiceProxy();
        this.locationServiceAdapter=new LocationServiceAdapter();
    }

    public WeatherData getWeatherByCity(String city) throws Exception {

        try{
            return weatherServiceProxy.getWeatherDataByCity(city);
        }
        catch(Exception e){
            throw new Exception("Could not get weather data for city: "+city);
        }

    }

    public WeatherData getWeatherByIP() throws Exception {
        try{
            return weatherServiceProxy.getWeatherDataByIP();
        }
        catch(Exception e){
            throw new Exception("Could not get weather data for your location");
        }
    }

    public LocationData getCurrentLocation() throws Exception
    {
        try{
            return locationServiceAdapter.getLocationData();

        }catch(Exception e)
        {
            throw new Exception("Could not get your location");
        }
    }
}
