using Newtonsoft.Json.Linq;
using System.Net;
using System.Threading.Tasks;
using System;

namespace _210042111_Lab08
{
    public class OpenWeatherMapApi
    {
        private readonly string ApiKey = "dac1719e24399fbaddf4ad41b384611b";

        public async Task<WeatherData> GetWeatherByCityAsync(string cityName)
        {
            string apiUrl = $"https://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={ApiKey}&units=metric";
            return await FetchWeatherData(apiUrl);
        }

        public async Task<WeatherData> GetWeatherByCoordinatesAsync(double latitude, double longitude)
        {
            string apiUrl = $"https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={ApiKey}&units=metric";
            return await FetchWeatherData(apiUrl);
        }

        private async Task<WeatherData> FetchWeatherData(string apiUrl)
        {
            string response = await SendGetRequestAsync(apiUrl);
            JObject json = JObject.Parse(response);
            string cityName = json["name"].ToString();
            double temperature = (double)json["main"]["temp"];
            string weatherCondition = json["weather"][0]["description"].ToString();

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
