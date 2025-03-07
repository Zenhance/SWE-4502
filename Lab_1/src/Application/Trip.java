package Application;

import Manager.DriverManager;
import RideType.RideType;

public class Trip {

    public int id;
    public String StartLocation;
    public String EndLocation;
    public RideType rideType;
    public double fare;
    public boolean status;

    public Driver driver;

    public Trip(int id, String StartLocation, String EndLocation, RideType rideType, double fare, boolean status){
        this.id = id;
        this.StartLocation = StartLocation;
        this.EndLocation = EndLocation;
        this.rideType = rideType;
        this.status = status;

        calculateFare(rideType);
    }

    private void calculateFare(RideType rideType){
        this.fare = rideType.calculateFare();
    }

    public void assignDriver(){
        this.driver = DriverManager.AssignDriver();
    }
}
