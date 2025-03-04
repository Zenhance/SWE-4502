using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class Weather
    {
        public double Temperature { get; set; }
        public string Condition { get; set; }
        public Location Location { get; set; }
        public string Source { get; set; } // kottheke nibo tar jonno
                                           // "WeatherStack" or "OpenWeather"


        public Weather(double temperature, string condition, Location location, string source)
        {
            Temperature = temperature;
            Condition = condition;
            Location = location;
            Source = source;
        }


        public Weather(Location location)
        {
            Location = location;
        }

        public double GetTemperature()
        {
            return Temperature;
        }

        public string GetCondition()
        {
            return Condition;
        }

        public string GetSource()
        {
            return Source;
        }

        public void ShowInfo()
        {
            Console.WriteLine($"Weather in {Location.GetCity()} from {Source}: {Temperature}°C, {Condition}");
        }
    }
}
