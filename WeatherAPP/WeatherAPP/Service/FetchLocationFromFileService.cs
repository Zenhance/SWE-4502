using System.Text.Json;
using WeatherAPP.Environment;
using WeatherAPP.Model;

namespace WeatherAPP.Service
{
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
                    if (item.TryGetProperty("ip", out JsonElement ipElement) && ipElement.GetString() == ip)
                    {
                        location = new Location
                        {
                            Ip = item.TryGetProperty("ip", out var prop) ? prop.GetString() : null,
                            ContinentCode = item.TryGetProperty("continentCode", out prop) ? prop.GetString() : null,
                            ContinentName = item.TryGetProperty("continentName", out prop) ? prop.GetString() : null,
                            CountryCode = item.TryGetProperty("countryCode", out prop) ? prop.GetString() : null,
                            CountryName = item.TryGetProperty("countryName", out prop) ? prop.GetString() : null,
                            CountryNameNative = item.TryGetProperty("countryNameNative", out prop) ? prop.GetString() : null,
                            OfficialCountryName = item.TryGetProperty("officialCountryName", out prop) ? prop.GetString() : null,
                            RegionCode = item.TryGetProperty("regionCode", out prop) ? prop.GetString() : null,
                            RegionName = item.TryGetProperty("regionName", out prop) ? prop.GetString() : null,
                            CityGeoNameId = item.TryGetProperty("cityGeoNameId", out prop) ? prop.GetInt32() : 0,
                            City = item.TryGetProperty("city", out prop) ? prop.GetString() : null,
                            PostalCode = item.TryGetProperty("postalCode", out prop) ? prop.GetString() : null,
                            Latitude = item.TryGetProperty("latitude", out prop) ? prop.GetDouble() : 0,
                            Longitude = item.TryGetProperty("longitude", out prop) ? prop.GetDouble() : 0,
                            Capital = item.TryGetProperty("capital", out prop) ? prop.GetString() : null,
                            PhoneCode = item.TryGetProperty("phoneCode", out prop) ? prop.GetString() : null,
                            CountryFlagEmoj = item.TryGetProperty("countryFlagEmoj", out prop) ? prop.GetString() : null,
                            CountryFlagEmojUnicode = item.TryGetProperty("countryFlagEmojUnicode", out prop) ? prop.GetString() : null,
                            IsEu = item.TryGetProperty("isEu", out prop) && prop.GetBoolean(),
                            Borders = item.TryGetProperty("borders", out prop) 
                                ? prop.EnumerateArray().Select(x => x.GetString()).ToList() 
                                : new List<string>(),
                            TopLevelDomains = item.TryGetProperty("topLevelDomains", out prop) 
                                ? prop.EnumerateArray().Select(x => x.GetString()).ToList() 
                                : new List<string>()
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
}
