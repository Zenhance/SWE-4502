using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.config
{
    public class ApiKey
    {
        private string ipStackApiKey = "secret";
        private string openWeatherMapApiKey = "secret";

        public string GetIpStackApiKey()
        {
            return ipStackApiKey;
        }

        public string GetOpenWeatherMapApiKey()
        {
            return openWeatherMapApiKey;
        }
    }
}
