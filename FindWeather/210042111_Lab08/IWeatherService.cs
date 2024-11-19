using System.Threading.Tasks;
namespace _210042111_Lab08
{
    public interface IWeatherService
    {
        Task<WeatherData> GetWeather(string cityName);

    }
}
