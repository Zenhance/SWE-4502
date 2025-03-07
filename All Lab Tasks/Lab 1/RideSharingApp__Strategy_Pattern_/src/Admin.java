public class Admin {
    private int id;
    private String name;

    public Admin(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void manageDriver(Driver driver) {
        System.out.println(name + " is managing driver: " + driver.getName());
    }

    public void viewTripHistory(Trip trip) {
        System.out.println("Trip history: " + trip.getStatus() + " from " + trip.getPickupLocation() + " to " + trip.getDropOffLocation() + ".");
    }

    public void handleDispute(Rider rider, Driver driver) {
        System.out.println("Admin handling dispute between " + rider.getName() + " and " + driver.getName() + ".");
    }

    public void displayInfo() {
        System.out.println("Admin: " + name);
    }
}
