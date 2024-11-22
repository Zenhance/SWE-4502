using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class WeatherServiceProxy : IWeatherService
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
            string key = cityName?.ToLower() ?? "auto-location"; // Handle null or empty city names
            DateTime now = DateTime.Now;

            if (cache.TryGetValue(key, out WeatherCache cachedData))
            {
                if ((now - cachedData.Timestamp) < CacheDuration)
                {
                    Console.WriteLine("Returning cached data.");
                    return cachedData.WeatherData;
                }

                if ((now - cachedData.Timestamp) < RateLimitDuration)
                {
                    throw new Exception("Rate limit exceeded. Please try again later.");
                }
            }

            Console.WriteLine("Fetching new data.");
            WeatherData weatherData = await weatherService.GetWeather(cityName);
            cache[key] = new WeatherCache(weatherData, now);
            return weatherData;
        }
    }
}
