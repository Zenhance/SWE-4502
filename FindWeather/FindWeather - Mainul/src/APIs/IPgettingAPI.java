package APIs;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class IPgettingAPI {
    public String getIP(){
        String url = "https://api.ipify.org/";

        try {
            HttpClient client = newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
