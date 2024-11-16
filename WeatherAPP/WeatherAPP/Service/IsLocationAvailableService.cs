using System.Text.Json;
using WeatherAPP.Environment;

namespace WeatherAPP.Service;

public class IsLocationAvailableService
{
    private readonly string _root;
    private readonly string _location;

    public IsLocationAvailableService()
    {
        _root = WEnvironment.GetRootDirPath();
        _location = WEnvironment.GetLocationFilePath();
    }

    public bool Execute(string ip)
    {
        try
        {
            JsonDocument locationJson = new JSONReaderService().ReadJSON(_location);

            JsonElement root = locationJson.RootElement;

            if (root.ValueKind == JsonValueKind.Array)
            {
                foreach (JsonElement item in root.EnumerateArray())
                {
                    if (item.TryGetProperty("ip", out JsonElement ipElement) && ipElement.GetString() == ip)
                    {
                        return true;
                    }
                }
            }

            return false;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error while checking IP: {ex.Message}");
            return false;
        }
        
    }
}