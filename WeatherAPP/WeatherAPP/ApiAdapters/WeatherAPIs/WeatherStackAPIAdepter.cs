namespace WeatherAPP.ApiAdapters.WeatherAPIs;

public class WeatherStackAPIAdapter : IWeatherAdapter
{
    private string _city;

    private readonly string _url =
        "http://api.weatherstack.com/current?access_key=abad40a649a54808aaaaeed9be38e6e7&query=";

    public WeatherStackAPIAdapter(string city)
    {
        _city = city;
        _url = _url + city;
    }
    
    public string GetWeather()
    {
        try
        {
            using (HttpClient client = new HttpClient())
            {
                return client.GetStringAsync(_url).Result;
            }
        }
        catch (Exception exception)
        {
            Console.WriteLine("Error Fetching Weather from Weather Stack" + exception.Message);
            throw;
        }
    }
}