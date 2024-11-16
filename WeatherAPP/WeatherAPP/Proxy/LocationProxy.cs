﻿using System.Text.Json;
using WeatherAPP.ApiAdapters;
using WeatherAPP.ApiAdapters.WeatherAPIs;
using WeatherAPP.Environment;
using WeatherAPP.Model;
using WeatherAPP.Service;

namespace WeatherAPP.Proxy;

public class LocationProxy
{
    private string _locationFilePath;
    private Location _location;
    
    public LocationProxy(string ip)
    {
        _locationFilePath = WEnvironment.GetLocationFilePath();
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
        }
    }
    
    
    public Location GetLocation()
    {
        return _location;
    }
}