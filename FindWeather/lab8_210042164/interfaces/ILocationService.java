package lab8_210042164.interfaces;

import java.io.IOException;

public interface ILocationService {
    void getLocationByIP() throws IOException;
    void getCity() throws IOException;
    String getLatitude();
    String getLongitude();
}
