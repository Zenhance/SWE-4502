using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class Weather
    { 
        public Location location;
        public double Temperature { get; set; } 
        public string Conditions { get; set; }
        public Location Location { get; set; }
        public string Source { get; set; }

        public Weather(double Temperature, string Conditions, Location Location, string Source)
        {
            this.Temperature = Temperature;
            this.Conditions = Conditions;
            this.Location = Location;
            this.Source = Source;
        }

        public Weather(Location location)
        {
            this.location = location;
        }

        public void DisplayWeather()
        {
            Console.WriteLine($"Weather in {Location.GetCity()} from {Source}: {Temperature}°C, {Conditions}\n");
        }
    }
}
