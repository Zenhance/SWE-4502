package Lab8_210042166.Service_Class;

import Lab8_210042166.Interface.ILocationService;

import java.io.IOException;

import import Lab8_210042166.API_Class.weatherAPI;

public class LocationService implements ILocationService {
    private static final String Ipstack_Key="7142a60d97e2ab19188ce0dfe70015b0";
    private String latitude;
    private String longitude;


    @Override
    public void getLocationIP() throws IOException{
        String ip=weatherAPI.getResponse("https://api.ipify.org");

    }
}
