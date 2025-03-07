namespace WeatherAPP.ApiAdapters;

public class LocationApiAdapter
{
    public string GetLocation(string ip)
    {
        string url = "https://apiip.net/api/check?";
        string accessKey = "dcd156c4-5edf-476d-b3c3-04e296dfa036";
        
        url = url + "ip=" + ip + "&accessKey=" + accessKey;

        try
        {
            using (HttpClient client = new HttpClient())
            {
                string response = client.GetStringAsync(url).Result;
                Console.WriteLine("Fetching Location from IPAPI");
                return response;
            }
        }
        catch(Exception exception)
        {
            Console.WriteLine("Error fetching your location " + exception.Message);
            throw;
        }
    }
}