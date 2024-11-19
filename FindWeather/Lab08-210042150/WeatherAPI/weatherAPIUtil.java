package WeatherAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class weatherAPIUtil {
    public static String getResponse(String urlString) throws IOException{
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();


    }
}
