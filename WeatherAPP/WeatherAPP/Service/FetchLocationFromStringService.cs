using System.Text.Json;
using WeatherAPP.Model;

namespace WeatherAPP.Service
{
    public class FetchLocationFromStringService
    {
        public Location Execute(string jsonContent)
        {
            try
            {
                var options = new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                };

                Location location = JsonSerializer.Deserialize<Location>(jsonContent, options);
                return location;
            }
            catch (Exception exception)
            {
                Console.WriteLine($"Error deserializing location data: {exception.Message}");
                return null;
            }
        }
    }
}