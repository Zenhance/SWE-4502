using WeatherAPP.Service;

namespace WeatherAPP.Proxy;

public class LocationProxy
{
    
    public string GetLocation()
    {
        IService service = new StructureCheckOrCreate();
        service.Execute();


        return "";

    }
}