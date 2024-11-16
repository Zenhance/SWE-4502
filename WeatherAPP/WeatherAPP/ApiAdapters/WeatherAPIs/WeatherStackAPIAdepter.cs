using System;
using System.Net.Http;
using System.Text.Json;
using WeatherAPP.Model;

namespace WeatherAPP.ApiAdapters.WeatherAPIs
{
    public class WeatherStackAPIAdapter : IWeatherAdapter
    {
        private string _city;

        private readonly string _url =
            "http://api.weatherstack.com/current?access_key=abad40a649a54808aaaaeed9be38e6e7&query=";

        public WeatherStackAPIAdapter(string city)
        {
            _city = city;
            _url = _url + city;
        }

        private string FetchWeather()
        {
            try
            {
                using (HttpClient client = new HttpClient())
                {
                    return client.GetStringAsync(_url).Result;
                }
            }
            catch (Exception exception)
            {
                Console.WriteLine("Error Fetching Weather from Weather Stack: " + exception.Message);
                throw;
            }
        }

        public Wether GetWeather()
        {
            string response = FetchWeather();

            try
            {
                JsonDocument jsonDocument = JsonDocument.Parse(response);

                // Extract relevant information from the JSON response
                JsonElement locationElement = jsonDocument.RootElement.GetProperty("location");
                JsonElement currentElement = jsonDocument.RootElement.GetProperty("current");

                return new Wether
                {
                    Time = DateTime.Parse(locationElement.GetProperty("localtime").GetString()),
                    Latitude = double.Parse(locationElement.GetProperty("lat").GetString()),
                    Longitude = double.Parse(locationElement.GetProperty("lon").GetString()),
                    Temperature = currentElement.GetProperty("temperature").GetDouble(),
                    Humidity = currentElement.GetProperty("humidity").GetDouble(),
                    Description = currentElement.GetProperty("weather_descriptions")[0].GetString()
                };
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error parsing weather data: " + ex.Message);
                throw;
            }
        }
    }
}
