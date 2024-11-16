using System.Text.Json;
using WeatherAPP.Model;

namespace WeatherAPP.Service;

public class FetchLocationFromStringService
{
    public Location Execute(string jsonContent)
    {
        try
        {
            Location location = JsonSerializer.Deserialize<Location>(jsonContent);
            return location;
        }
        catch (Exception exception)
        {
            Console.WriteLine(exception);
            throw;
        }
    }
}