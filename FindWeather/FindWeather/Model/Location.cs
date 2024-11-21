using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather.Model
{
    internal class Location
    {
        public double Latitude { get; set; }
        public double Longitude { get; set; }
        public string City { get; set; }

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
