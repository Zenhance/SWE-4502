public class OpenWeatherAdapter implements IWeatherAdapter{
    @Override
public Weather getWeather(Location location)  {
    return OpenWeatherAPI.Get_Weather(location);
}
}