public class Trip {
    private int id;
    private static int tripIdCounter = 1;
    private String pickupLocation;
    private String dropOffLocation;
    private RideType rideType;
    private String status;
    private double fare;
    private double distance;
    private String ridingHour;
    private Double tripTime;
    private Rider rider;
    private Driver driver;

    public Trip(Rider rider, String pickupLocation, String dropOffLocation, RideType rideType) {
        this.id = tripIdCounter++;
        this.rider = rider;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.status = "Pending";
    }

    public double calculateFare() {
        double baseFare = rideType.getBaseFare();
        double distanceRate = rideType.getDistanceRate();
        double surcharge = getSurcharge();
        double timeRate= rideType.getTimeRate();

        double fare = baseFare * surcharge + distance * distanceRate + tripTime * timeRate;

        if(rideType.getCategory().equals("Shared"))
            return  fare/ rideType.getCapacity();

        return fare;
    }
    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = "Accepted";
        NotificationService.sendNotification("Driver " + driver.getName() +  " has been assigned for your trip.");
    }

    public void startTrip() {
        this.status = "In Progress";
        NotificationService.sendNotification("Your trip has started from " + pickupLocation + " for " + dropOffLocation);
    }

    public void completeTrip(double distance, double time) {
        this.distance = distance;
        this.tripTime = time;
        this.status = "Completed";
        double fare = calculateFare();
        NotificationService.sendNotification("Your trip is complete. Your fare is: " + fare + " BDT/-");
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getSurcharge(){
        //Surcharge will depend on rideTime, tripTime and demand
        return 1;
    }

    public Driver getDriver() {
        return driver;
    }

    public Rider getRider() {
        return rider;
    }
}
