import APIs.WeatherStackAPI;
import APIs.openWeatherAPI;
import adapters.OpenWeatherAdapter;
import concreteClasses.utility.TimeManager;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        openWeatherAPI api = new openWeatherAPI("e3dfd49f7917fe082f153b64f7ab41b9");
        JSONObject obj = api.fetchData("Dhaka");
        System.out.println(obj);
    }
}
