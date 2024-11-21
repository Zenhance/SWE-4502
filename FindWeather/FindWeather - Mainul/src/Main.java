import APIs.WeatherStackAPI;
import concreteClasses.utility.TimeManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        TimeManager tm = new TimeManager();
        System.out.println(tm.isTimeWithinLast10Minutes("2024-11-21 17:15"));
    }
}
