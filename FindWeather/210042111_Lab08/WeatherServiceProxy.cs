using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class WeatherServiceProxy: IWeatherService
    {
        private readonly IWeatherService weatherService;
        private readonly Dictionary<string, WeatherCache> cache = new Dictionary<string, WeatherCache>();
        private static readonly TimeSpan CacheDuration = TimeSpan.FromMinutes(10);
        private static readonly TimeSpan RateLimitDuration = TimeSpan.FromSeconds(30);
        public WeatherServiceProxy(IWeatherService weatherService)
        {
            this.weatherService = weatherService;
        }
        public async Task<WeatherData> GetWeather(string cityName)
        {
            string key = cityName.ToLower();
            DateTime now = DateTime.Now;
        }
}
