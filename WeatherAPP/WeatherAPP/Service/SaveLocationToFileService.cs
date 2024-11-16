using WeatherAPP.Environment;
using System.Text.Json;

namespace WeatherAPP.Service;

public class SaveLocationToFileService
{
    private readonly string _locationPath;
    
    public SaveLocationToFileService()
    {
        _locationPath = WEnvironment.GetLocationFilePath();
    }
    
    public void Execute(string locationString)
    {
        try
        {
            JsonElement newLocation = JsonDocument.Parse(locationString).RootElement;

            string jsonContent = File.Exists(_locationPath) ? File.ReadAllText(_locationPath) : "[]";

            JsonDocument existingData = JsonDocument.Parse(jsonContent);
            var locations = existingData.RootElement.EnumerateArray().ToList();

            locations.Add(newLocation);

            string updatedJson = JsonSerializer.Serialize(locations, new JsonSerializerOptions
            {
                WriteIndented = true // For readable formatting
            });

            File.WriteAllText(_locationPath, updatedJson);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error while appending location data: {ex.Message}");
        }
    }
}