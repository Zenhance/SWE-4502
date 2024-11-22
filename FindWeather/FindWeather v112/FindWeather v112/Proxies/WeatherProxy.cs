using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherProxy:IWeatherProvider
    {
        public IWeatherProvider provider;
        public Dictionary<string, (WeatherData, DateTime)> cache = new Dictionary<string, (WeatherData, DateTime)>();
        public DateTime lastRequestTime = DateTime.MinValue;
        public WeatherProxy(IWeatherProvider provider)
        {
            this.provider = provider;
        }
        public async Task<WeatherData> GetWeatherAsync(double latitude, double longitude)
        {
            string key = $"{latitude},{longitude}";
            if (cache.ContainsKey(key) && (DateTime.Now - cache[key].Item2).TotalMinutes < 10)//cache
            {
                return cache[key].Item1;
            }
            if ((DateTime.Now - lastRequestTime).TotalSeconds < 30)//rate limiter
            {
                throw new Exception("Rate limit reached. Please wait.");
            }
            var data = await provider.GetWeatherAsync(latitude, longitude);
            cache[key] = (data, DateTime.Now);
            lastRequestTime = DateTime.Now;
            return data;
        }
        public async Task<WeatherData> GetWeatherByCityAsync(string city)
        {
            if (cache.ContainsKey(city) && (DateTime.Now - cache[city].Item2).TotalMinutes < 10)//cache
            {
                return cache[city].Item1;
            }
            if ((DateTime.Now - lastRequestTime).TotalSeconds < 30)//rate limiter
            {
                throw new Exception("Rate limit reached. Please wait.");
            }
            var data = await provider.GetWeatherByCityAsync(city);
            cache[city] = (data, DateTime.Now);
            lastRequestTime = DateTime.Now;
            return data;
        }
    }
}
