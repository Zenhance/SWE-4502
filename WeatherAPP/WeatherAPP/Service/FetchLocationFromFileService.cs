using System.Text.Json;
using WeatherAPP.Environment;
using WeatherAPP.Model;

namespace WeatherAPP.Service;

public class FetchLocationFromFileService
{
    private readonly string _locationPath;
    
    public FetchLocationFromFileService()
    {
        _locationPath = WEnvironment.GetLocationFilePath();
    }
    
    public Location Execute(string ip)
    {
        try
        {
            Location location;

            string jsonContent = File.ReadAllText(_locationPath);

            JsonDocument locationJson = JsonDocument.Parse(jsonContent);

            foreach (JsonElement item in locationJson.RootElement.EnumerateArray())
            {
                if (item.GetProperty("ip").GetString() == ip)
                {
                    location = new Location
                    {
                        Ip = item.GetProperty("ip").GetString(),
                        ContinentCode = item.GetProperty("continentCode").GetString(),
                        ContinentName = item.GetProperty("continentName").GetString(),
                        CountryCode = item.GetProperty("countryCode").GetString(),
                        CountryName = item.GetProperty("countryName").GetString(),
                        CountryNameNative = item.GetProperty("countryNameNative").GetString(),
                        OfficialCountryName = item.GetProperty("officialCountryName").GetString(),
                        RegionCode = item.GetProperty("regionCode").GetString(),
                        RegionName = item.GetProperty("regionName").GetString(),
                        CityGeoNameId = item.GetProperty("cityGeoNameId").GetInt32(),
                        City = item.GetProperty("city").GetString(),
                        PostalCode = item.GetProperty("postalCode").GetString(),
                        Latitude = item.GetProperty("latitude").GetDouble(),
                        Longitude = item.GetProperty("longitude").GetDouble(),
                        Capital = item.GetProperty("capital").GetString(),
                        PhoneCode = item.GetProperty("phoneCode").GetString(),
                        CountryFlagEmoj = item.GetProperty("countryFlagEmoj").GetString(),
                        CountryFlagEmojUnicode = item.GetProperty("countryFlagEmojUnicode").GetString(),
                        IsEu = item.GetProperty("isEu").GetBoolean(),
                        Borders = item.GetProperty("borders").EnumerateArray().Select(x => x.GetString()).ToList(),
                        TopLevelDomains = item.GetProperty("topLevelDomains").EnumerateArray()
                            .Select(x => x.GetString()).ToList()
                    };

                    return location;
                }
            }

            throw new Exception($"IP {ip} is not found");
        }
        catch (Exception exception)
        {
            Console.WriteLine($"Error fetching location for IP {ip}: {exception.Message}");
            return null;
        }
    }
}