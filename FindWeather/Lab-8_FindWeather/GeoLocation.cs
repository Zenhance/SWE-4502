using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Text.Json;
using System.IO;
using Newtonsoft.Json.Linq;
using System.Collections;

namespace Lab_8_FindWeather
{
    public class GeoLocation
    {
        private const string GET_URL = "http://api.weatherstack.com/current?access_key=";
        private const string WEATHERSTACK_API_KEY = "cb96da099a6f212128efba4fdc3a5463";

        // Eigula private const karon eigula fixed values and should not be modified.


        public static Location get_location_by_city(string city)
        {
            string urlString = GET_URL + WEATHERSTACK_API_KEY + "&query=" + city;

            // URL Construction:

            // This line constructs the full URL for the API request by combining:

                // The base URL(GET_URL).
                // The API key(WEATHERSTACK_API_KEY).
                // The city name(city) as a query parameter.


            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(urlString);
            // HttpWebRequest is used to create an HTTP request to the API.
            request.Method = "GET";
            // GET request (Retrieve data)

            using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
            // HttpWebResponse is used to get the response from the API.

            using (Stream stream = response.GetResponseStream())
            using (StreamReader reader = new StreamReader(stream))
            {
                string responseText = reader.ReadToEnd();
                JObject jsonObject = JObject.Parse(responseText);
                JObject location = (JObject)jsonObject["location"]; // Extracts the location object from the JSON response.

                double latitude = (double)location["lat"];
                double longitude = (double)location["lon"];

                return new Location(city, latitude, longitude);
            }

        }
    }
}
