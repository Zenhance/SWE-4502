using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class LocationService
    {
        private const string IpApiUrl = "http://ip-api.com/json/";

        public async Task<(double Latitude, double Longitude)> GetLocationFromIpAsync()
        {
            string response = await SendGetRequestAsync(IpApiUrl);
            JObject json = JObject.Parse(response);

            if (json["status"]?.ToString() == "success")
            {
                double latitude = (double)json["lat"];
                double longitude = (double)json["lon"];
                return (latitude, longitude);
            }

            throw new Exception("Unable to retrieve location information from IP.");
        }

        private async Task<string> SendGetRequestAsync(string apiUrl)
        {
            using (WebClient client = new WebClient())
            {
                return await client.DownloadStringTaskAsync(new Uri(apiUrl));
            }
        }
    }
}
