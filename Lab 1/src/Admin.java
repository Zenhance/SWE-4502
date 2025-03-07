import java.util.ArrayList;
import java.util.List;

public class Admin {
    private int id;
    private String name;

    List<Trip> trips = new ArrayList<Trip>();

    public Admin(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void manageDriver(Driver driver) {
        // code
    }

    public void manageRider(Rider rider) {
        // code
    }

    public void viewTripHistory() {
        for(Trip trip : trips){
            System.out.println(trip);
        }
    }

    public void viewTripHistory(Driver driver) {
        for(Trip trip : trips){
            if(trip.getDriver().equals(driver)) {
                System.out.println(trip);
            }
        }
    }

    public void viewTripHistory(Rider rider) {
        for(Trip trip : trips){
            if(trip.getRider().equals(rider)) {
                System.out.println(trip);
            }
        }
    }

    public void handleDispute() {
        // code
    }
}
