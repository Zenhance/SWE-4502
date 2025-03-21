using FindWeather.Data;

namespace FindWeather.Weather
{
    public class WeatherApiProxy : IWeatherAPI
    {
        private readonly Dictionary<string, IWeatherAPI> _weatherApis;
        private readonly Dictionary<string, (WeatherData data, DateTime timestamp)> _cache;
        private readonly Dictionary<string, DateTime> _lastRequestTime;
        private readonly TimeSpan _cacheDuration = TimeSpan.FromMinutes(10);
        private readonly TimeSpan _rateLimit = TimeSpan.FromSeconds(30);
        
        private string _lastApiUsed;

        public WeatherApiProxy(Dictionary<string, IWeatherAPI> weatherApis)
        {
            _weatherApis = weatherApis;
            _cache = new Dictionary<string, (WeatherData, DateTime)>();
            _lastRequestTime = new Dictionary<string, DateTime>();
            _lastApiUsed = _weatherApis.Keys.First();
        }

        public WeatherData GetWeatherData(double latitude, double longitude)
        {
            var apiToUse = SwitchToOtherApi();

            var cacheKey = $"{apiToUse}_{latitude},{longitude}";

            if (_cache.ContainsKey(cacheKey) && (DateTime.Now - _cache[cacheKey].timestamp) < _cacheDuration)
            {
                Console.WriteLine($"Returning cached data from {apiToUse}.");
                return _cache[cacheKey].data;
            }

            if (_lastRequestTime.ContainsKey(apiToUse) && (DateTime.Now - _lastRequestTime[apiToUse]) < _rateLimit)
            {
                Console.WriteLine($"Rate limit reached for {apiToUse}. Using the other API.");

                apiToUse = SwitchToOtherApi();
                cacheKey = $"{apiToUse}_{latitude},{longitude}";

                if (_cache.ContainsKey(cacheKey) && (DateTime.Now - _cache[cacheKey].timestamp) < _cacheDuration)
                {
                    Console.WriteLine($"Returning cached data from {apiToUse}.");
                    return _cache[cacheKey].data;
                }
            }

            var selectedApi = _weatherApis[apiToUse];
            var data = selectedApi.GetWeatherData(latitude, longitude);

            _cache[cacheKey] = (data, DateTime.Now);
            _lastRequestTime[apiToUse] = DateTime.Now;
            _lastApiUsed = apiToUse;

            Console.WriteLine($"Data retrieved from {apiToUse}.");
            return data;
        }

        private string SwitchToOtherApi()
        {
            return _weatherApis.Keys.First(api => api != _lastApiUsed);
        }
    }
}
