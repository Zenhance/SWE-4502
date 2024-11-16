using System;
using System.Text.Json;
using WeatherAPP.Model;

namespace WeatherAPP.ApiAdapters.WeatherAPIs
{
    public class OpenWetherApiAdapter : IWeatherAdapter
    {
        private double _latitude { get; set; }
        private double _longitude { get; set; }

        private string url = "https://api.openweathermap.org/data/2.5/weather?";
        private string accessKey = "92be5e44d0a8840d3155df89e34ca665";

        private string _final_url;

        public OpenWetherApiAdapter(double latitude, double longitude)
        {
            _latitude = latitude;
            _longitude = longitude;
            _final_url = $"{url}lat={_latitude}&lon={_longitude}&appid={accessKey}";
        }

        private string FetchWeather()
        {
            try
            {
                using (HttpClient client = new HttpClient())
                {
                    return client.GetStringAsync(_final_url).Result;
                }
            }
            catch (Exception exception)
            {
                Console.WriteLine("Error Fetching Weather from Open Weather: " + exception.Message);
                throw;
            }
        }

        public Wether GetWeather()
        {
            string response = FetchWeather();

            try
            {
                JsonDocument jsonDocument = JsonDocument.Parse(response);

                // Parse the JSON response to extract necessary data
                var mainElement = jsonDocument.RootElement.GetProperty("main");
                var weatherElement = jsonDocument.RootElement.GetProperty("weather")[0];
                var coordElement = jsonDocument.RootElement.GetProperty("coord");

                return new Wether
                {
                    Time = DateTimeOffset.FromUnixTimeSeconds(jsonDocument.RootElement.GetProperty("dt").GetInt64()).DateTime,
                    Latitude = coordElement.GetProperty("lat").GetDouble(),
                    Longitude = coordElement.GetProperty("lon").GetDouble(),
                    Temperature = mainElement.GetProperty("temp").GetDouble(),
                    Humidity = mainElement.GetProperty("humidity").GetDouble(),
                    Description = weatherElement.GetProperty("description").GetString()
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
