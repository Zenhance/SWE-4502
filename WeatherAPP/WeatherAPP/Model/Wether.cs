namespace WeatherAPP.Model;

public class Wether
{
    public DateTime Time { get; set; }
    
    public double Latitude { get; set; }
    public double Longitude { get; set; }
    public double Temperature { get; set; }
    public double Humidity { get; set; }
    public string Description { get; set; }
    
    
    public double GetTemperatureInCelsius()
    {
        if(Temperature > 100)
        {
            return Temperature - 273.15;
        }
        return Temperature;
    }
    
    public double GetHumidity()
    {
        return Humidity;
    }
    
    public string GetDescription()
    {
        return Description;
    }
    
    
}