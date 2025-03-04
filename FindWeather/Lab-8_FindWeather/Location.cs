using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class Location
    {
        public string City { get; set; }
        public double Latitude { get; set; }
        public double Longitude { get; set; }

        public Location(string city, double latitude, double longitude)
        {
            City = city;
            Latitude = latitude;
            Longitude = longitude;
        }

        public string GetCity()
        {
            return City;
        }


        public double GetLatitude()
        {
            return Latitude;
        }

        public double GetLongitude()
        {
            return Longitude;
        }

        public void ShowInfo()
        {
            Console.WriteLine($"City: {City}, Latitude: {Latitude}, Longitude: {Longitude}");
        }

    }
}
