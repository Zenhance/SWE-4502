using System;
using System.Text.Json;
using WeatherAPP.Model;
using WeatherAPP.Environment;

namespace WeatherAPP.Service
{
    public class FetchWetherFromFileService
    {
        private readonly string _WeatherPath;

        public FetchWetherFromFileService()
        {
            _WeatherPath = WEnvironment.GetWeatherFilePath();
        }

        public Wether Execute(Location location)
        {
            string path = _WeatherPath + location + ".json";

            // Read the JSON data
            JsonDocument jsonDocument = new JSONReaderService().ReadJSON(path);

            double currentLat = location.Latitude;
            double currentLon = location.Longitude;
            int currentHour = DateTime.Now.Hour;

            // Iterate through the JSON and find the first matching weather object
            foreach (JsonElement element in jsonDocument.RootElement.EnumerateArray())
            {
                // Extract latitude and longitude from the JSON element
                double lat = element.GetProperty("Latitude").GetDouble();
                double lon = element.GetProperty("Longitude").GetDouble();
                DateTime time = element.GetProperty("Time").GetDateTime();
                int hour = time.Hour;

                // Check if the conditions are met
                if (Math.Abs(lat - currentLat) <= 0.1 &&
                    Math.Abs(lon - currentLon) <= 0.1 &&
                    hour == currentHour)
                {
                    // Create and return a Wether object from the matching JSON record
                    return new Wether
                    {
                        Time = time,
                        Latitude = lat,
                        Longitude = lon,
                        Temperature = element.GetProperty("Temperature").GetDouble(),
                        Humidity = element.GetProperty("Humidity").GetDouble(),
                        Description = element.GetProperty("Description").GetString()
                    };
                }
            }

            // Return null if no matching record is found
            return null;
        }
    }
}
