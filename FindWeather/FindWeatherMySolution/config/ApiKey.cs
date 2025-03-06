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

        public string GetIpStackApiKey()
        {
            return ipStackApiKey;
        }
    }
}
