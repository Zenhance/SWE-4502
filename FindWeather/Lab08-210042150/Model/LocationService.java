package Model;

import Interfaces.ILocationService;

import java.io.IOException;

import WeatherAPI.weatherAPIUtil;

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

    @Override
    public String getCity() throws IOException {
        String ip = weatherAPIUtil.getResponse("https://api.ipify.org");
        String locationResponse = weatherAPIUtil.getResponse(
                "http://api.ipstack.com/" + ip + "?access_key=" + IPSTACK_API_KEY
        );

        String city = weatherAPIUtil.extractValue(locationResponse, "\"city\":\"", "\"");
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
