namespace WeatherAPP.Environment;

public static class WEnvironment
{
    public static string GetRootDirPath()
    {
        return ".weatherH";
    }

    public static string GetLocationFilePath()
    {
        return ".weatherH/locations.json";
    }
    
    public static string GetWeatherFilePath()
    {
        return ".weatherH/weather.json";
    }
}