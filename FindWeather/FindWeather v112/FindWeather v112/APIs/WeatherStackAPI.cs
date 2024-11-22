using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherStackAPI
    {
        private readonly string apiKey = "1d5774fb918f8d1301086452e73b086b";
        private readonly HttpClient client = new HttpClient();
        public async Task<string> FetchWeatherData(double latitude, double longitude)
        {
            string url = $"http://api.weatherstack.com/current?access_key={apiKey}&query={latitude},{longitude}";
            return await client.GetStringAsync(url);
        }
    }
}
