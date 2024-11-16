using WeatherAPP.Environment;

namespace WeatherAPP.Service;

public class IsLocationAvailableService
{
    private readonly string _root;
    private readonly string _location;

    public IsLocationAvailableService()
    {
        _root = WEnvironment.GetRootDirPath();
        _location = WEnvironment.GetLocationFilePath();
    }

    public void Execute()
    {
        
    }
}