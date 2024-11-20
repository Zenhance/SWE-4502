package models;

public class WeatherData 
{
    public Double temperature;
    public String conditions;
    public String locationInfo;
    public String source;

    public WeatherData(Double temperature, String conditions, String locationInfo, String source)
    {
        this.temperature = temperature;
        this.conditions = conditions;
        this.locationInfo = locationInfo;
        this.source = source;
    }

    public void displayData() 
    {
        System.out.println("Data retrieved from " + source);
        System.out.printf("Weather in %s from %s: %.2f°C, %s%n", locationInfo, source, temperature, conditions);
    }
}
