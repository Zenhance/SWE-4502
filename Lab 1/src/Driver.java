public class Driver {
    private int id;
    private String name;
    private RideType vehicleType;
    private String location;
    private double rating;
    private int trips;
    private boolean availability;

    public Driver(int id, String name, RideType vehicleType) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.location = getLocation();
        this.rating = 0;
        this.availability = false;
    }

    public String getLocation() {
        location = "Pickup Point";
        return location;
    }

    public void setAvailable(Boolean av)
    {
        this.availability= av;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips){
        this.trips = trips;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void acceptRide(Trip trip) {
        setAvailable(false);
        trip.assignDriver(this);
    }

    public void rateRider(Rider rider, double rating) {
        double getRating = rider.getRating();
        int getTrips= rider.getTrips();

        double totalRating = getTrips*getRating + rating;
        int totalTrips = getTrips+1;

        rider.setTrips(totalTrips);
        rider.setRating(totalRating/totalTrips);
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }

    public void startTrip(Trip trip) {
        trip.startTrip();
    }

    public String getName() {
        return name;
    }
}
