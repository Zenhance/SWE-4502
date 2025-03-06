using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_8_FindWeather
{
    public interface ILocationService
    {
        (string City, double Latitude, double Longitude) GetLocationByIp();
        (string City, double Latitude, double Longitude) GetLocationByCity(string cityName);
    }
}
