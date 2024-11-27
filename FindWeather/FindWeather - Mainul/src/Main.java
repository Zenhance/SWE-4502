import APIs.IPStackAPI;
import APIs.IPgettingAPI;
import APIs.WeatherStackAPI;
import APIs.openWeatherAPI;
import adapters.IPStackAPIAdapter;
import adapters.OpenWeatherAdapter;
import adapters.WeatherStackAdapter;
import concreteClasses.WeatherData;
import concreteClasses.WeatherService;
import concreteClasses.utility.Menu;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.printMainMenu();
        Scanner myObj = new Scanner(System.in);
        int input = Integer.parseInt(myObj.nextLine());
        if(input>0 && input<3){

//            String cityName = menu.getcityName(input);
            WeatherService weatherService = new WeatherService();
            weatherService.printWeatherData("Dhaka");
        }

    }
}
