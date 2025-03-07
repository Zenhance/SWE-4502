using System.Text.Json;
using WeatherAPP.ApiAdapters;
using WeatherAPP.ApiAdapters.WeatherAPIs;
using WeatherAPP.Environment;
using WeatherAPP.Model;
using WeatherAPP.Service;

namespace WeatherAPP.Proxy;

public class LocationProxy
{
    private Location _location;
    
    public LocationProxy(string ip)
    {
        new StructureCheckOrCreate().Execute();
        FetchLocation(ip);
    }
    
    private void FetchLocation(string ip)
    {
        bool isLocationAvailable = new IsLocationAvailableService().Execute(ip);

        if (isLocationAvailable)
        {
            _location = new FetchLocationFromFileService().Execute(ip);
        }
        else
        {
            LocationApiAdapter locationApiAdapter = new LocationApiAdapter();
            string locationString = locationApiAdapter.GetLocation(ip);
            _location = new FetchLocationFromStringService().Execute(locationString);
            new SaveLocationToFileService().Execute(locationString);
        }
    }
    
    
    public Location GetLocation()
    {
        return _location;
    }
}