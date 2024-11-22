﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace FindWeather_v112
{
    internal class WeatherFacade
    {
        public WeatherProxy weatherStackProxy;
        public WeatherProxy openWeatherProxy;
        public (double Latitude, double Longitude)? cachedLocation = null;
        public WeatherFacade()
        {
            var weatherStack = new WeatherStackAdapter();
            var openWeather = new OpenWeatherAdapter();
            weatherStackProxy = new WeatherProxy(weatherStack);
            openWeatherProxy = new WeatherProxy(openWeather);
        }
        public async Task<(double Latitude, double Longitude)> GetLocation()
        {
            if (cachedLocation.HasValue)
            {
                Console.WriteLine("Using cached location.");
                return cachedLocation.Value;
            }
            string ip = await new HttpClient().GetStringAsync("https://api.ipify.org");
            string url = $"http://api.ipstack.com/{ip}?access_key=de9240a0520081a9ce9e78214ec3e707";
        }
    }
}
