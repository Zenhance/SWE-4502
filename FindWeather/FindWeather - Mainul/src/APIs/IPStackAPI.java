package APIs;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class IPStackAPI {
    private String api_key;
    private String base_url;
    public IPStackAPI(String _api_key){
        api_key = _api_key; //355dbc2e06a2a5956bc522f5a7d1ca21
        base_url = "https://api.ipstack.com/";
    }
    public JSONObject fetchData(String ip){
        String url = base_url + ip+"?access_key=" + api_key;

        try {
            HttpClient client = newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            return new JSONObject(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
