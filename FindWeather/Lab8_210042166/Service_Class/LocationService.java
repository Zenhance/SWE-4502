package Lab8_210042166.Service_Class;

import Lab8_210042166.Interface.ILocationService;

import java.io.IOException;
 import Lab8_210042166.API_Class.weatherAPI;

public class LocationService implements ILocationService {
    private static final String Ipstack_Key="7142a60d97e2ab19188ce0dfe70015b0";
    private String latitude;
    private String longitude;


    @Override
    public void getLocationIP() throws IOException{
        String ip=weatherAPI.getResponse("https://api.ipify.org");
        String locationResponse = weatherAPI.getResponse(
                "https://ipstack.com/" + ip + "?access_key=" + Ipstack_Key
        );

        this.latitude = weatherAPI.getValue(locationResponse, "\"latitude\":", ",");
        this.longitude = weatherAPI.getValue(locationResponse, "\"longitude\":", ",");
        System.out.println("Detected location by IP: Lat: " + latitude + ", Lon: " + longitude);

    }

    @Override
    public String getCity()throws IOException{
        String ip = weatherAPI.getResponse("https://api.ipify.org");
        String locationResponse = weatherAPI.getResponse(
                "https://ipstack.com/" + ip + "?access_key=" + Ipstack_Key
        );
        String city = weatherAPI.getValue(locationResponse, "\"city\":\"", "\"");
        System.out.println("Detected city: " + city);
        return city != null && !city.equals("null") ? city : "Unknown City";
    }

    @Override
    public String getLatitude() {
        return latitude;
    }
    @Override
    public String getLongitude() {
        return longitude;
    }

}
