namespace WeatherAPP.Service;

public class StructureCheckOrCreate : IService
{
    private readonly string _root = ".weatheH";
    private readonly string _location = ".weatheH/locations.json";
    private readonly string _weather = ".weatheH/weather.json";
    
    public void Execute()
    {
        try
        {
            if (!Directory.Exists(_root))
            {
                Directory.CreateDirectory(_root);
            }

            if (!File.Exists(_location))
            {
                File.Create(_location);
            }

            if (!File.Exists(_weather))
            {
                File.Create(_weather);
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}