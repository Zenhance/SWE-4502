using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Text.Json;
using System.IO;
using Newtonsoft.Json.Linq;
using System.Collections;
using System.Text.Json.Nodes;
using System;

namespace Lab_8_FindWeather
{
    public class WeatherStackAPI
    {
        private const String WeatherStack_API_KEY = "cb96da099a6f212128efba4fdc3a5463";
        // Eita private const karon eigula fixed values and should not be modified.

        public static Weather Get_Weather(Location location)
        {
            string urlString = $"http://api.weatherstack.com/current?access_key={WeatherStack_API_KEY}&query={location.GetCity()}&units=m";
            // URL Construction:

            // This line constructs the full URL for the API request by combining:


            // The base URL(http://api.openweathermap.org/data/2.5/weather).
            // The city name(location.GetCity()) as a query parameter.
            // The API key(OpenWeather_API_KEY).
            // The units(metric for Celsius).


            // HTTP request
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(urlString);       // Create an HTTP request to the API.
            request.Method = "GET";         // GET request (used to retrieve data).


            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())       // HttpWebResponse is used to get the response from the API.
            using (Stream stream = response.GetResponseStream())                            // retrieves the data stream from the response.
            using (StreamReader reader = new StreamReader(stream))
            {
                string responseText = reader.ReadToEnd();


                JsonNode jsonObject = JsonNode.Parse(responseText);         // Parse the JSON response

                double temperature = jsonObject["current"]["temperature"].GetValue<double>();
                // retrieves the temperature value from the main object in the JSON response.


                string weatherCondition = jsonObject["current"]["weather_descriptions"][0].GetValue<string>();
                // retrieves the weather condition description from the weather array in the JSON response.

                return new Weather(temperature, weatherCondition, location, "WeatherStack");

            }
        }
    }
}
