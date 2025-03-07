using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class ProxyWeatherService : IWeatherService
    {
        private readonly RealWeatherService realWeatherService;
        private readonly ConcurrentDictionary<string, Weather> cache;
        private readonly ConcurrentDictionary<string, DateTime> cacheTimestamps;

        public ProxyWeatherService()
        {
            this.realWeatherService = new RealWeatherService();
            this.cache = new ConcurrentDictionary<string, Weather>();
            this.cacheTimestamps = new ConcurrentDictionary<string, DateTime>();
        }

        public Weather GetWeather(Location location)
        {
            string key = location.GetCity().ToLower();

            if (cache.TryGetValue(key, out Weather cachedWeather) && !IsCacheExpired(key))
            {
                Console.WriteLine("Fetching weather data for location: " + location.GetCity() + " from cache");
                return cachedWeather;
            }
            else
            {
                Weather weather = realWeatherService.GetWeather(location);
                cache[key] = weather;
                cacheTimestamps[key] = DateTime.Now;
                Console.WriteLine("Fetching weather data for location: " + location.GetCity() + " from API");
                return weather;
            }
        }

        private bool IsCacheExpired(string key)
        {
            if (!cacheTimestamps.TryGetValue(key, out DateTime lastFetchedTime))
            {
                return true; // Cache entry does not exist
            }

            TimeSpan duration = DateTime.Now - lastFetchedTime;
            return duration.TotalSeconds > 5; // Cache expires after 5 seconds
        }
    }
}
