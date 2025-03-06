using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class LocationService : ILocationService
    {
        private readonly string _ipStackApiKey;

        public LocationService(string ipStackApiKey)
        {
            _ipStackApiKey = ipStackApiKey;
        }

        public (string City, double Latitude, double Longitude) GetLocationByIp()
        {
            try
            {
                // Get IP address
                var ipResponse = new HttpClient().GetStringAsync("https://api.ipify.org?format=json").Result;
                var ipAddress = JsonConvert.DeserializeObject<dynamic>(ipResponse).ip;

                // Get location details using IP
                var locationResponse = new HttpClient().GetStringAsync($"http://api.ipstack.com/{ipAddress}?access_key={_ipStackApiKey}").Result;
                var locationData = JsonConvert.DeserializeObject<dynamic>(locationResponse);

                return (locationData.city, locationData.latitude, locationData.longitude);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error detecting location by IP: {ex.Message}");
                return (null, 0, 0);
            }
        }

        public (string City, double Latitude, double Longitude) GetLocationByCity(string cityName)
        {
            try
            {
                // Use OpenWeather's geocoding API to get coordinates
                var geocodeResponse = new HttpClient().GetStringAsync($"http://api.openweathermap.org/geo/1.0/direct?q={cityName}&limit=1&appid=YOUR_OPENWEATHER_API_KEY").Result;
                var geocodeData = JsonConvert.DeserializeObject<dynamic>(geocodeResponse);

                if (geocodeData.Count == 0)
                {
                    Console.WriteLine("City not found.");
                    return (null, 0, 0);
                }

                return (geocodeData[0].name, geocodeData[0].lat, geocodeData[0].lon);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error detecting location by city: {ex.Message}");
                return (null, 0, 0);
            }
        }
    }
}
