using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeather.Model
{
    internal class LocationService
    {
        HttpClient _httpClient;
        public LocationService()
        {
            _httpClient = new HttpClient();
        }

        public async Task<string> FindIp()
        {
            var uri = Utility.GetIpifyURL();
            return await _httpClient.GetStringAsync(uri);
        }
        public async Task<Location?> FindLocationByIp()
        {
            var ip = FindIp().Result;
            var uri = Utility.GetIpStackURL() + ip + "/?access_key=" + Utility.GetIPStackApiKey();
            var response = await _httpClient.GetAsync(uri).Result.Content.ReadAsStreamAsync();
            var location = JsonSerializer.Deserialize<Location>(response);
            Console.WriteLine(JsonSerializer.Serialize(location));
            return location;
        }
    }
}
