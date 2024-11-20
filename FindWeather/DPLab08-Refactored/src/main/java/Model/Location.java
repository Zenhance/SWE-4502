package Model;


public class Location {

    private String city;
    private double latitude;
    private double longitude;

    public Location(String city, double latitude, double longitude) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

}
