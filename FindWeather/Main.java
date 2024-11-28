import APIs.IPStackAPI;
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


        WeatherStackAPI api2 = new WeatherStackAPI("4c31a3c95ae754203e58d51a39643e4b");
        obj = api2.fetchAPI("Dhaka");
        System.out.println(obj);

        IPStackAPI api3 = new IPStackAPI("355dbc2e06a2a5956bc522f5a7d1ca21");
        System.out.println(api3.fetchData("103.106.243.130"));
    }
}
