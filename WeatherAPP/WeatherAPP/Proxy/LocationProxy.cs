using System.Text.Json;
using WeatherAPP.Environment;
using WeatherAPP.Service;

namespace WeatherAPP.Proxy;

public class LocationProxy
{

    private string _locationFilePath;
    private JsonDocument _locationJson;
    
    public LocationProxy()
    {
        _locationFilePath = WEnvironment.GetLocationFilePath();
        new StructureCheckOrCreate().Execute();
        
    }
    
    public string GetLocation(string ip)
    {
        
        return "";

    }
}