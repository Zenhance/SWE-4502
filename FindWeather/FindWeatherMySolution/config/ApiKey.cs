using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeatherMySolution.config
{
    public class ApiKey
    {
        private string ipStackApiKey = "s";
        private string openWeatherMapApiKey = "s";
        private string weatherStackApiKey = "s";

        public string GetIpStackApiKey()
        {
            return ipStackApiKey;
        }

        public string GetOpenWeatherMapApiKey()
        {
            return openWeatherMapApiKey;
        }

        public string GetWeatherStackApiKey()
        {
            return weatherStackApiKey;
        }
    }
}
