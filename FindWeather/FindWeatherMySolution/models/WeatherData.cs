using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.models
{
    public class WeatherData
    {
        public Location Location { get; set; }
        public double Temperature { get; set; }
        public string Conditions { get; set; }
        public string Source { get; set; }
        public DateTime Timestamp { get; set; }

        public void ShowDetails()
        {
            Console.WriteLine("Weather Data:");
            Console.WriteLine($"Location: {Location?.City}");
            Console.WriteLine($"Temperature: {Temperature}°C");
            Console.WriteLine($"Conditions: {Conditions}");
            Console.WriteLine($"Source: {Source}");
            Console.WriteLine($"Timestamp: {Timestamp}");
        }
    }
}
