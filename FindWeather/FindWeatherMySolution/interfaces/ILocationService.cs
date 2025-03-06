using FindWeatherMySolution.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.interfaces
{
    public interface ILocationService
    {
        Task<Location> GetLocationByIp();
    }
}
