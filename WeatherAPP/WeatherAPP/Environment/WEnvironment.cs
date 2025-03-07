namespace WeatherAPP.Environment;

public static class WEnvironment
{
    public static string GetRootDirPath()
    {
        return ".rakin";
    }

    public static string GetLocationFilePath()
    {
        return GetRootDirPath() + "/locations.json";
    }
    
    public static string GetWeatherFilePath()
    {
        return GetRootDirPath() + "/weather.json";
    }
}