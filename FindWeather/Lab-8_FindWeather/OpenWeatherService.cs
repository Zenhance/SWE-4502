using System;
using System.Net;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;

namespace Lab_8_FindWeather
{
    public class OpenWeatherService
    {
        private readonly string apiKey = "c5bccf8c818a881df3ca71ba1b66663e";

        public Weather GetWeather(string city)
        {
            // Create WebClient to make HTTP request
            WebClient client = new WebClient();
            string response = "";

            try
            {
                // Build API URL
                string url = $"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

                // Get weather data from API as a string
                response = client.DownloadString(url);
            }
            finally
            {
                // Ensure WebClient is properly closed
                client.Dispose();
            }

            // Convert JSON response to an object
            var weatherJson = JsonSerializer.Deserialize<JsonElement>(response);

            // Extract data and return a Weather object
            double temperature = weatherJson.GetProperty("main").GetProperty("temp").GetDouble();
            string condition = weatherJson.GetProperty("weather")[0].GetProperty("description").GetString();
            string cityName = weatherJson.GetProperty("name").GetString();

            return new Weather(temperature, condition, new Location(cityName, 0, 0), "OpenWeather");
        }
    }
}
