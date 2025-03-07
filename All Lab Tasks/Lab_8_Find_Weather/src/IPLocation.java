import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IPLocation
{
    private static final String GET_URL_IP="http://api.ipify.org";//Get the IP
    private static final String GET_URL_GeoLocation="http://api.ipstack.com/";
    private static final String IPStack_API_KEY="bf4dc083bd7d004f5b75494704ca39d9";
    public static Location get_Location_by_IP() throws IOException {
        //Amar IP_address jene nicchi
        URL url=new URL(GET_URL_IP);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner=new Scanner(url.openStream());
        String IP_address=scanner.next();
        scanner.close();


        //IP_address diye latitude,longitude find krtesi
        //http://api.ipstack.com/134.201.250.155?access_key=YOUR_ACCESS_KEY   (From Documentation)

        url=new URL(GET_URL_GeoLocation + IP_address + "?access_key=" + IPStack_API_KEY);
        conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        scanner=new Scanner(url.openStream());
        StringBuilder inline =new StringBuilder();
        while (scanner.hasNext())
        {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        JSONObject jsonObject=new JSONObject(inline.toString());


        String city=jsonObject.getString("city");
        double latitude=jsonObject.getDouble("latitude");
        double longitude=jsonObject.getDouble("longitude");

        return new Location(city,latitude,longitude);
    }

}
