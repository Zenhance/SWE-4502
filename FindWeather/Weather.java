public class Weather {
    public Location location;
    public double temperature;
    public String weather_condition;
    public String WeatherAPI_name;

    public Weather(double temperature, String weather_condition, Location location, String WeatherAPI_name) {
        this.temperature = temperature;
        this.weather_condition = weather_condition;
        this.location = location;
        this.WeatherAPI_name = WeatherAPI_name;
    }
    public void printWeather() {
        System.out.println("Weather in " + location.getCity() + " from " + WeatherAPI_name + ": "
                + temperature +  + weather_condition);
    }


}