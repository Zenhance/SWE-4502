using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public class WeatherData
    {
        public double Temperature { get; set; } 
        public string Conditions { get; set; }
        public string Location { get; set; }
        public string Source { get; set; }

        public override string ToString()
        {
            return $"Weather in {Location} from {Source}: {Temperature}°C, {Conditions}";
        }
    }
}
