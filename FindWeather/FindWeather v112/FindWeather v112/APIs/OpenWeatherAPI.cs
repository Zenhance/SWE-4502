using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather_v112.APIs
{
    internal class OpenWeatherAPI
    {
        private readonly string apiKey = "6478730e0f11b84d687c7b57123b8fbf";
        private readonly HttpClient client = new HttpClient();
        public async Task<string> FetchWeatherDataByCoordinatesAsync(double latitude, double longitude)
        {
            string url = $"https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&units=metric&appid={apiKey}";
            return await client.GetStringAsync(url);
        }

    }
}
