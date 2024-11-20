package Models;

public class WeatherData {
   public String temperature;
   public  String conditions;
   public  String locationInformation;
   public  String source;

    public WeatherData(String temperature, String conditions, String locationInformation, String source){
        this.temperature = temperature;
        this.conditions = conditions;
        this.locationInformation = locationInformation;
        this.source = source;
    }

    
}
