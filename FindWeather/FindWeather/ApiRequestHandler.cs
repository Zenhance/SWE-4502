using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather
{
    internal class ApiRequestHandler
    {
        private HttpClient _client;
        public ApiRequestHandler()
        {
            _client = new HttpClient();
        }
        public async Task<string> Get(string uri)
        {
            return await _client.GetStringAsync(uri);
        }
    }
}
