package IpServices;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IpStackService {
    private final String ApiKey = "6f97c01d7812a64550fb69c59a001387";
    private final String BaseUrl = "http://api.ipstack.com/";

    public String getCurrentIPAddress() {
        String url = "https://api.ipify.org?format=json";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.body());

            if (jsonResponse.containsKey("ip")) {
                return jsonResponse.get("ip").toString();
            } else {
                System.out.println("Invalid IP response structure: " + jsonResponse);
            }
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
