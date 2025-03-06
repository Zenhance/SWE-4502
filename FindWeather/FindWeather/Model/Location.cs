using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace FindWeather.Model
{
    internal class Location
    {
        [JsonPropertyName("latitude")]
        public double Latitude { get; set; }
        [JsonPropertyName("longitude")]
        public double Longitude { get; set; }
        [JsonPropertyName("city")]
        public string City { get; set; }

        public Location()
        {
        }

        public Location(string city)
        {
            City = city;
        }

        public Location(double latitude, double longitude, string city)
        {
            Latitude = latitude;
            Longitude = longitude;
            City = city;
        }
    }
}
