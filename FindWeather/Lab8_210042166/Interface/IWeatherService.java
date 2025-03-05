package Lab8_210042166.Interface;
import java.io.IOException;

public interface IWeatherService {
    void getWeatherThroughCity(String city) throws IOException;
    void getWeatherThroughLocation(String latitude,String longitude,String city) throws IOException;
}
