using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.models
{
    public class Location
    {
        public string City { get; set; }
        public double Latitude { get; set; }
        public double Longitude { get; set; }

        public void ShowDetails()
        {
            Console.WriteLine("City: " + City);
            Console.WriteLine("Latitude: " + Latitude.ToString());
            Console.WriteLine("Longitude: " + Longitude.ToString());
        }
    }
}
