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