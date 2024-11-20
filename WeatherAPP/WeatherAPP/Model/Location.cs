namespace WeatherAPP.Model;

public class Location
{
    public string Ip { get; set; }
    public string ContinentCode { get; set; }
    public string ContinentName { get; set; }
    public string CountryCode { get; set; }
    public string CountryName { get; set; }
    public string CountryNameNative { get; set; }
    public string OfficialCountryName { get; set; }
    public string RegionCode { get; set; }
    public string RegionName { get; set; }
    public int CityGeoNameId { get; set; }
    public string City { get; set; }
    public string PostalCode { get; set; }
    public double Latitude { get; set; }
    public double Longitude { get; set; }
    public string Capital { get; set; }
    public string PhoneCode { get; set; }
    public string CountryFlagEmoj { get; set; }
    public string CountryFlagEmojUnicode { get; set; }
    public bool IsEu { get; set; }
    public List<string> Borders { get; set; }
    public List<string> TopLevelDomains { get; set; }

    // Optionally, you can override the ToString method for debugging or display purposes
    public override string ToString()
    {
        return $"IP: {Ip}, City: {City}, Country: {CountryName}, Latitude: {Latitude}, Longitude: {Longitude}";
    }
    
    
}
