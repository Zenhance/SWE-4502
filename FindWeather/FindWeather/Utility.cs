using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather
{
    internal class Utility
    {
        public static string GetOpenWeatherApiKey()
        {
            return "4df25a7d7dd382af8190650fcd3a7b44";
        }

        public static string GetWeatherStackApiKey()
        {
            return "a129ddb3efe33641bc599101dca6ee73";
        }

        public static string GetIPStackApiKey()
        {
            return "954b0451d5d871f97c771ef2c8bcb3b0";
        }

        public static string GetIpifyURL()
        {
            return "https://api.ipify.org/";
        }

        public static string GetIpStackURL()
        {
            return "http://api.ipstack.com/";
        }
    }
}
