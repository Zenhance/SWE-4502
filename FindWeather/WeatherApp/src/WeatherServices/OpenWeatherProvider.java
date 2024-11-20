package WeatherServices;

import Models.WeatherData;

public class OpenWeatherProvider implements IWeatherProvider {
    String ApiKey = "8b2131d2c1d531dd655dde21ebfc3984";
    String BaseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";
    

    public WeatherData getWeatherData(String location){
        String Url = BaseUrl + location + "&appid=" + ApiKey;
        // need to call api and get response
        // create weatherdata using the response body    
    
        WeatherData weatherData = new WeatherData("32", "Sunny", "Dhaka", "OpenWeather");
        return weatherData;
    }
}
