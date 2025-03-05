package Lab8_210042166.API_Class;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class weatherAPI {
    public static String getResponse(String urlString)throws IOException{
        URL url=new URL(urlString);
        HttpURLConnection connection=(HttpURLConnection).url.openConnecction();
        connection.setRequestMethod("GET");
        connection.connect();

        int response=connection.getResponseCode();
    }

}
