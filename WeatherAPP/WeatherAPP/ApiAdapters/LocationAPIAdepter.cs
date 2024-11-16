namespace WeatherAPP.ApiAdapters;

public class LocationAPIAdapter
{
    public string GetLocation(string ip)
    {
        string url = "https://apiip.net/api/check?";
        string accessKey = "dcd156c4-5edf-476d-b3c3-04e296dfa036";
        
        url = url + "ip=" + ip + "&accessKey=" + accessKey;
        
        
    }
}