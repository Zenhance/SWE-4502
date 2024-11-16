using System;
using System.Linq;
using System.Text.Json;
using WeatherAPP.Model;
using WeatherAPP.Environment;

namespace WeatherAPP.Service
{
    public class IsWeatherAvailableService
    {
        private string WeatherJsonPath;

        public IsWeatherAvailableService()
        {
            WeatherJsonPath = WEnvironment.GetWeatherFilePath();
        }

        public bool Execute(Location location)
        {
            // Read the JSON data
            JsonDocument jsonData = new JSONReaderService().ReadJSON(WeatherJsonPath);

            double currentLat = location.Latitude;
            double currentLon = location.Longitude;
            int currentHour = DateTime.Now.Hour;

            // Parse and check conditions
            foreach (JsonElement element in jsonData.RootElement.EnumerateArray())
            {
                double lat = element.GetProperty("Latitude").GetDouble();
                double lon = element.GetProperty("Longitude").GetDouble();
                DateTime time = element.GetProperty("Time").GetDateTime();
                int hour = time.Hour;

                // Check if the conditions are met
                if (Math.Abs(lat - currentLat) <= 0.1 &&
                    Math.Abs(lon - currentLon) <= 0.1 &&
                    hour == currentHour)
                {
                    return true;
                }
            }

            // Return false if no matching record is found
            return false;
        }
    }
}