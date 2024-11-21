using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
        public async Task<Location> FindLocationByIp()
        {
            var ip = FindIp().Result;
            var uri = Utility.GetIpStackURL() + ip + "?access_key=" + Utility.GetIPStackApiKey();
            await Console.Out.WriteLineAsync(uri);
            try
            {
                var response = await _httpClient.GetAsync(uri);
                await Console.Out.WriteLineAsync(await response.Content.ReadAsStringAsync());
            }
            catch (Exception e) {
                await Console.Out.WriteLineAsync(e.Message);
            }
            return new Location("gg");
        }
    }
}
