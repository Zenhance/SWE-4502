using Newtonsoft.Json.Linq;
using System;
using System.Net;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class LocationService
    {
        const string IpGeolocationApiUrl = "https://api.ipgeolocation.io/ipgeo";
        const string ApiKey = "d4c075512e4f4ce1bfc3152da99ae268"; 

        public async Task<(double Latitude, double Longitude)> GetLocationFromIpAsync()
        {
            string apiUrl = $"{IpGeolocationApiUrl}?apiKey={ApiKey}";
            string response = await SendGetRequestAsync(apiUrl);
            JObject json = JObject.Parse(response);

            if (json["latitude"] != null && json["longitude"] != null)
            {
                double latitude = double.Parse(json["latitude"].ToString());
                double longitude = double.Parse(json["longitude"].ToString());
                return (latitude, longitude);
            }

            throw new Exception("Unable to retrieve location information from IP.");
        }

        public async Task<string> SendGetRequestAsync(string apiUrl)
        {
            using (WebClient client = new WebClient())
            {
                return await client.DownloadStringTaskAsync(new Uri(apiUrl));
            }
        }
    }
}
