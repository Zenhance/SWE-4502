using System.Threading.Tasks;
namespace _210042111_Lab08
{
    public class OpenWeatherMapAdapter : IWeatherService
    {
        private readonly OpenWeatherMapApi weatherApi;
        private readonly LocationService locationService;

        public OpenWeatherMapAdapter()
        {
            weatherApi = new OpenWeatherMapApi();
            locationService = new LocationService();
        }

        public async Task<WeatherData> GetWeather(string cityName)
        {
            if (!string.IsNullOrEmpty(cityName))
            {
                return await weatherApi.GetWeatherByCityAsync(cityName);
            }

            var (latitude, longitude) = await locationService.GetLocationFromIpAsync();
            return await weatherApi.GetWeatherByCoordinatesAsync(latitude, longitude);
        }
    }
}
