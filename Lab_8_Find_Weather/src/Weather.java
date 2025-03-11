public class Weather
{
    public Location location;
    public double temperature;
    public String weather_condition;

    public Weather(double temperature,String weather_condition,Location location)
    {
        this.temperature=temperature;
        this.weather_condition=weather_condition;
        this.location=location;

    }

    public void DisplayWeather()
    {
        System.out.println("Weather in "+ location.getCity()+" from WeatherStack: " + temperature+", "+weather_condition);
        //Weather in Mirpur from WeatherStack: 23°C, Clear
    }


}
