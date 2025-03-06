package lab8_210042164.Services;

import lab8_210042164.API_classes.WeatherApi;
import lab8_210042164.interfaces.ILocationService;

import javax.imageio.IIOException;
import java.io.IOException;

public class LocationService implements ILocationService {
    private static final String IPSTACK_API_KEY = "defb538de968ec25de982feec7710fe8"; //key from ipstack.com
    private String latitude;
    private String longitude;

    @Override
    public  void getLocationByIP() throws IOException {
        String ip = WeatherApi.getResponse("https://api.ipify.org");
        String locationResponse = WeatherApi.getResponse("http://api.ipstack.com/" + ip + "?access_key=" + IPSTACK_API_KEY);
        this.latitude = WeatherApi.extractValue(locationResponse, "\"latitude\":", ",");
        this.longitude = WeatherApi.extractValue(locationResponse, "\"longitude\":", ",");
        System.out.println("Detected location by IP: Lat: " + latitude + ", Lon: " + longitude);

    }
    @Override
    public void getCity() throws IOException {
        String ip = WeatherApi.getResponse("https://api.ipify.org");
        String locationResponse = WeatherApi.getResponse("http://api.ipstack.com/" + ip + "?access_key=" + IPSTACK_API_KEY);
        String city = WeatherApi.extractValue(locationResponse, "\"city\":\"", "\",");
        System.out.println("Detected city by IP: " + city);
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
