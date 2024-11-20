using Newtonsoft.Json.Linq;
using System.Net;
using System.Threading.Tasks;
using System;

namespace _210042111_Lab08
{
    public class OpenWeatherMapAdapter: IWeatherService
    {
        string ApiKey = "dac1719e24399fbaddf4ad41b384611b";
        public async Task<WeatherData> GetWeather(string cityName)
        {
            string apiUrl = $"https://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={ApiKey}&units=metric";
            string response = await SendGetRequestAsync(apiUrl);
            JObject json = JObject.Parse(response);
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
