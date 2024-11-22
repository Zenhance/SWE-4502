using Newtonsoft.Json.Linq;
using System;
using System.Net;
using System.Threading.Tasks;
namespace _210042111_Lab08
{
    public class WeatherStackAdapters : IWeatherService
    {
        string ApiKey = "309d469af3c87de70e7d58bfa498d1e9";
        public async Task<WeatherData> GetWeather(string cityName)
        {
            string apiUrl = $"http://api.weatherstack.com/current?access_key={ApiKey}&query={cityName}";
            string response = await SendGetRequestAsync(apiUrl);
            JObject json = JObject.Parse(response);
            string weatherCondition = json["current"]["weather_descriptions"][0].ToString();
            double temperature = (double)json["current"]["temperature"];
            return new WeatherData(cityName, weatherCondition, temperature);
        }
        private async Task<string> SendGetRequestAsync(string apiUrl)
        {
            using (WebClient client = new WebClient())
            {
                return await client.DownloadStringTaskAsync(new Uri(apiUrl));
            }
        }
    }
}
