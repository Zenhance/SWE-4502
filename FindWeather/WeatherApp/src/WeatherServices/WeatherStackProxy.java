package WeatherServices;

import Models.WeatherData;
import Utils.WeatherCache;

public class WeatherStackProxy implements IWeatherProvider{
    private final WeatherStackProvider provider = new WeatherStackProvider();
    private final WeatherCache weatherCache = WeatherCache.getInstance();
    
    
    @Override
    public WeatherData getWeatherData(String location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWeatherData'");
    }
    
    
}
