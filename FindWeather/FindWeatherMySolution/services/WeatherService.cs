using FindWeatherMySolution.interfaces;
using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.services
{
    public class WeatherService : IWeatherService
    {
        private readonly List<IWeatherProvider> _weatherProviders;
        private readonly Dictionary<string, CacheItem> _cache;
        private int _currentProviderIndex = 0;

        private class CacheItem
        {
            public WeatherData Data { get; set; }
            public DateTime ExpiryTime { get; set; }
        }

        public WeatherService(List<IWeatherProvider> weatherProviders)
        {
            _weatherProviders = weatherProviders;
            _cache = new Dictionary<string, CacheItem>();
        }

        public async Task<WeatherData> GetWeather(Location location)
        {
            string cacheKey = location.City?.ToLower() ?? $"{location.Latitude},{location.Longitude}";

            
            if (_cache.TryGetValue(cacheKey, out var cacheItem) && cacheItem.ExpiryTime > DateTime.Now)
            {
                Console.WriteLine($"Retrieving weather data from cache for {cacheKey}");
                return cacheItem.Data;
            }

            var initialProviderIndex = _currentProviderIndex;
            Exception lastException = null;

            do
            {
                var provider = _weatherProviders[_currentProviderIndex];

                if ((DateTime.Now - provider.LastRequestTime).TotalSeconds < 30)
                {
                    Console.WriteLine($"Rate limit hit for {provider.Name}, switching provider...");
                    _currentProviderIndex = (_currentProviderIndex + 1) % _weatherProviders.Count;

                    if (_currentProviderIndex == initialProviderIndex)
                    {
                        var waitTime = 30 - (int)(DateTime.Now - provider.LastRequestTime).TotalSeconds;
                        Console.WriteLine($"All providers are rate limited. Please wait {waitTime} seconds.");
                        throw new Exception("All providers are rate limited. Please try again later.");
                    }

                    continue;
                }

                try
                {
                    provider.LastRequestTime = DateTime.Now;
                    var weatherData = await provider.GetWeatherData(location);

                    _cache[cacheKey] = new CacheItem
                    {
                        Data = weatherData,
                        ExpiryTime = DateTime.Now.AddMinutes(10)
                    };

                    _currentProviderIndex = (_currentProviderIndex + 1) % _weatherProviders.Count;

                    return weatherData;
                }
                catch (Exception ex)
                {
                    lastException = ex;
                    Console.WriteLine($"Error from {provider.Name}: {ex.Message}");
                    _currentProviderIndex = (_currentProviderIndex + 1) % _weatherProviders.Count;
                }

            } while (_currentProviderIndex != initialProviderIndex);

            throw lastException ?? new Exception("Failed to retrieve weather data from any provider.");
        }
    }
}
