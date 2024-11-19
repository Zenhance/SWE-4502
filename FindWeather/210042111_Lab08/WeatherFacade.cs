using lab08_210042111;

namespace _210042111_Lab08
{
    public class WeatherFacade
    {
        IWeatherService openWeatherMapAdapter;
        IWeatherService weatherStackAdapter;
        WeatherServiceProxy proxyWeatherStack;
        WeatherServiceProxy proxyOpenWeather;

    }
}
