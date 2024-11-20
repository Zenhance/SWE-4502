import APIs.WeatherStackAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherStackAPI wtapi = new WeatherStackAPI();
        wtapi.fetchAPI("Gazipur");
        System.out.println(wtapi.WeatherDescription());
        System.out.println(wtapi.getTemparature());
    }
}
