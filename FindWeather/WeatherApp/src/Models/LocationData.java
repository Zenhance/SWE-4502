package Models;

public class LocationData {
    public String city;
    public String country;
    public double latitude;
    public double longitude;

    public LocationData(String city, String country, double latitude, double longitude) {
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
