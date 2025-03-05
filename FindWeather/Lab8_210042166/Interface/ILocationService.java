package Lab8_210042166.Interface;
import java.io.IOException;
public interface ILocationService {
    void getLocationIP() throws IOException;
    String getCity() throws IOException;
    String getLatitude();
    String getLongitude();
}
