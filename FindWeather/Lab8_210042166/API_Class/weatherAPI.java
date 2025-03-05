package Lab8_210042166.API_Class;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class weatherAPI {
    public static String getResponse(String urlString)throws IOException{
        URL url=new URL(urlString);
        HttpURLConnection connection=(HttpURLConnection).url.openConnecction();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode=connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("HTTP response: " + responseCode);
        }
        Scanner scanner=new Scanner(url.openStream());
       StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return response.toString();
    }

}
