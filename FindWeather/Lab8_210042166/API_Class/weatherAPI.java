package Lab8_210042166.API_Class;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class weatherAPI {
    public static String getResponse(String urlString)throws IOException{
        URL url=new URL(urlString);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
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
    public static String getValue(String response,String keyStart,String keyEnd)
    {
        int startIndex=response.indexOf(keyStart);
        if (startIndex == -1) return "N/A";
        startIndex =startIndex+ keyStart.length();

        int endIndex=response.indexOf(keyEnd,startIndex);
        if (endIndex == -1) return "N/A";

        return response.substring(startIndex, endIndex);
    }

}
