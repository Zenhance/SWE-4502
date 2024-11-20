using Newtonsoft.Json.Linq;
using System;
using System.Net;
using System.Threading.Tasks;
namespace _210042111_Lab08
{
    public class WeatherStackAdapters
    {
        string ApiKey = "309d469af3c87de70e7d58bfa498d1e9"; 
        public async Task<WeatherData> GetWeather(string cityName)
        {
            string apiUrl = $"http://api.weatherstack.com/current?access_key={ApiKey}&query={cityName}";
            string response = await SendGetRequestAsync(apiUrl);
        }
}
