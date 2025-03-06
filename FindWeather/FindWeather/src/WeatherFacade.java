import Models.Location;
import Services.LocationService;
import Services.WeatherService;

public class WeatherFacade {
    private final LocationService locationService;
    private final WeatherService weatherService;

    public WeatherFacade() {
        this.locationService = new LocationService();
        this.weatherService = new WeatherService();
    }

    public void getWeatherByIP() {
        try {
            Location location = locationService.getLocationByIP();
            if (location != null) {
                weatherService.fetchWeather(location.getCity(), location.getLatitude(), location.getLongitude());
            } else {
                System.out.println("Could not determine location by IP.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getWeatherByCity(String city) {
        try {
            Location location = locationService.getLocationByCity(city);
            if (location != null) {
                weatherService.fetchWeather(location.getCity(), location.getLatitude(), location.getLongitude());
            } else {
                System.out.println("Invalid city name or location not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
