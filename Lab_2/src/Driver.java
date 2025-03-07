public class Driver {

    private int id;
    private String name;
    private String licenseNumber;
    private VEHICLETYPE vehicleType;
    private String location;
    private boolean availability;
    private double rating;

    public Driver(int id, String name, String licenseNumber, VEHICLETYPE vehicleType, String location, boolean availability, double rating) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.location = location;
        this.availability = availability;
        this.rating = rating;
    }

    public void setTrip(Trip trip) {
        System.out.println("Trip assigned to driver");
    }
}
