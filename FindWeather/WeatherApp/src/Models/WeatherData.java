package Models;

public class WeatherData {
   public Double temperature;
   public String conditions;
   public String locationInformation;
   public String source;

    public WeatherData(Double temperature, String conditions, String locationInformation, String source){
        this.temperature = temperature;
        this.conditions = conditions;
        this.locationInformation = locationInformation;
        this.source = source;
    }

    public void displayData() {
        System.out.println("Data retrieved from " + source);
        System.out.printf("Weather in %s from %s: %.2f°C, %s%n", locationInformation, source, temperature, conditions);
    }
}