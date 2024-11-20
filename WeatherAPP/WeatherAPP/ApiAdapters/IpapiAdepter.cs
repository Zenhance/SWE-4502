namespace WeatherAPP.ApiAdapters;

public class IpapiAdapter
{
    public string Getip()
    {
        string url = "https://api.ipify.org";

        try
        {
            using (HttpClient client = new HttpClient())
            {
                string ip = client.GetStringAsync(url).Result;
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