package Interfaces;

import java.io.IOException;

public interface ILocationService {
    void getLocationByIP() throws IOException;
    String getCity() throws IOException;
    String getLatitude();
    String getLongitude();
}
