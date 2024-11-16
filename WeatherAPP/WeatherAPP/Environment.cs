namespace WeatherAPP;

public static class Environment
{
    public static string GetRootDirPath()
    {
        return ".weatherH";
    }

    public static string GetLocationFilePath()
    {
        return ".weatheH/locations.json";
    }
    
    public static string GetWeatherFilePath()
    {
        return ".weatheH/weather.json";
    }
}