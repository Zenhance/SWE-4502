using System;
namespace _210042111_Lab08
{
    public class WeatherCache
    {
        public WeatherData WeatherData { get; }
        public DateTime Timestamp { get; }

        public WeatherCache(WeatherData weatherData, DateTime timestamp)
        {
            WeatherData = weatherData;
            Timestamp = timestamp;
        }
    }
}
