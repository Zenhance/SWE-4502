using FindWeatherMySolution.config;
using FindWeatherMySolution.interfaces;
using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeatherMySolution.services
{
    public class LocationService : ILocationService
    {
        private readonly HttpClient _httpClient;
        private readonly ApiKey _apiKey;

        public LocationService()
        {
            _httpClient = new HttpClient();
            _apiKey = new ApiKey();
        }

        public async Task<string> GetIP()
        {
            var ipResponse = await _httpClient.GetStringAsync("https://api.ipify.org");
            var ip = ipResponse.Trim();
            
            Console.WriteLine(ip);

            return ip;
        }

        public async Task<Location> GetLocationByIp()
        {
            try
            {
                var ip = await this.GetIP();
                string ipStackApiKey = _apiKey.GetIpStackApiKey();

                var locationResponse = await _httpClient.GetStringAsync($"http://api.ipstack.com/{ip}?access_key={ipStackApiKey}");

                var locationData = JsonSerializer.Deserialize<JsonElement>(locationResponse);

                return new Location
                {
                    City = locationData.GetProperty("city").GetString(),
                    Latitude = locationData.GetProperty("latitude").GetDouble(),
                    Longitude = locationData.GetProperty("longitude").GetDouble()
                };
            }

            catch (Exception ex)
            {
                Console.WriteLine($"Error getting location: {ex.Message}");
                throw;
            }
        }
    }
}
