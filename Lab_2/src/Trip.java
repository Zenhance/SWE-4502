public class Trip {
    private int id;
    private RideType rideType;
    private String pickUpLocation;
    private String dropLocation;
    private double distance;
    private double fare = -1;

    public Trip(int id, RideType rideType, String pickUpLocation, String dropLocation, double distance) {
        this.id = id;
        this.rideType = rideType;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
    }

    public double calculateFare() {
        if(this.fare < 0) {
            this.fare = this.rideType.calculatePrice();
        }
        return this.fare;
    }

    public void assignDriver(Driver driver) {
        driver.setTrip(this);
    }










    public int getId() {
        return id;
    }

    public RideType getRideType() {
        return rideType;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }




}
