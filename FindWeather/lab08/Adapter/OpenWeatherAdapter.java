package Adapter;

public class OpenWeatherAdapter implements IWeatherAdapter{
    @Override
public Weather getWeather(Location location) throws IOException ,JSONException {
    return OpenWeatherAPI.Get_Weather(location);
}
}
