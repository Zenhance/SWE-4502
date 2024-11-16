using System.Net;

namespace WeatherAPP.ApiAdepters;

public class IPAPIAdepter
{
    public string GETIP()
    {
        string url = "https://api.ipify.org";

        try
        {
            using (WebClient client = new WebClient())
            {
                string ip = client.DownloadString(url);
                return ip;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error Fetching IP : " + ex.Message);
            throw;
        }
    }
}