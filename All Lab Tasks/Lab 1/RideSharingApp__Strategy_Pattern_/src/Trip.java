public class Trip {
    private int id;
    private String pickupLocation;
    private String dropOffLocation;
    private RideType rideType;
    private double fare;
    private double distance;
    private Driver driver;
    private String status;

    public Trip(int id, String pickupLocation, String dropOffLocation, RideType rideType, double distance) {
        this.id = id;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.distance = distance;
        this.fare = calculateFare();
        this.status = "Requested";
    }

    public double calculateFare() {
        switch (rideType) {
            case CARPOOL:
                return distance * 20;

            case LUXURY:
                return distance * 35;

            case BIKE:
                return distance * 15;

            default:
                return distance * 10;
        }
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = "Driver Assigned";
    }

    public void startTrip() {
        this.status = "In Progress";
        System.out.println("Trip has started.");
    }

    public void completeTrip() {
        this.status = "Completed";
        System.out.println("Trip has been completed.");
    }

    public int getId() {
        return id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public RideType getRideType() {
        return rideType;
    }

    public double getFare() {
        return fare;
    }

    public double getDistance() {
        return distance;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getStatus() {
        return status;
    }
}
