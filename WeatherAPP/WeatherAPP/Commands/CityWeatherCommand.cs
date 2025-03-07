using WeatherAPP.ApiAdapters;
using WeatherAPP.ApiAdapters.WeatherAPIs;
using WeatherAPP.Model;

namespace WeatherAPP.Commands;

public class CityWeatherCommand : ICommand
{
    public string _city;

    public CityWeatherCommand(string city)
    {
        _city = city;
    }

    public void Execute()
    {
        Wether wether = new WeatherStackAPIAdapter(_city).GetWeather();
        
        string ip = new IpapiAdapter().Getip();
        
        double tempature = wether.GetTemperatureInCelsius();
        double humidity = wether.GetHumidity();
        string description = wether.GetDescription();
        
        double latitude = wether.Latitude;
        double longitude = wether.Longitude;
        
        DateTime time = wether.Time;
        
        
        
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine("=============== Weather ===============");
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Fetch Time: ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(time);
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Exact Location: ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine($"Latitude: {latitude} Longitude: {longitude}");
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Temperature: ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(tempature.ToString("F2") + "°C");
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Humidity: ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(humidity.ToString("F2") + "%");
        Console.ForegroundColor = ConsoleColor.Yellow;
        Console.Write("Description: ");
        Console.ForegroundColor = ConsoleColor.Cyan;
        Console.WriteLine(description);
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine("=======================================");
        Console.ResetColor();
    }
}