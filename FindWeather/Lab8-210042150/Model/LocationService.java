package Model;

import Interfaces.ILocationService;
import WeatherAPI.weatherAPIUtil;

import java.io.IOException;

public class LocationService implements ILocationService {
    private static final String IPSTACK_API_KEY = "4a075c3610c3cba539c3fd2aca4d76ab";
    private String latitude;
    private String longitude;

    @Override
    public void getLocationByIP() throws IOException {
        String ip = weatherAPIUtil.getResponse("https://api.ipify.org");
        String locationResponse = weatherAPIUtil.getResponse(
                "http://api.ipstack.com/" + ip + "?access_key=" + IPSTACK_API_KEY
        );

        this.latitude = weatherAPIUtil.extractValue(locationResponse, "\"latitude\":", ",");
        this.longitude = weatherAPIUtil.extractValue(locationResponse, "\"longitude\":", ",");
        System.out.println("Detected location by IP: Lat: " + latitude + ", Lon: " + longitude);
    }
}
