package Application;

import Factory.RatingFactory;

public class Driver {
    public int id;
    public String name;
    public String licenseNumber;
    public String location;
    public double rating;
    public boolean availability;

    public Driver(int id, String name, String licenseNumber, String location, double rating, boolean availability){
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.location = location;
        this.rating = rating;
        this.availability = availability;
    }

    public void acceptRide(){
        Application.DemoSleep.sleep(2);
        System.out.println("Ride Accepted! by Driver: " + this.name);
        startTrip();
    }

    public void rateRider(){
        double rating = RatingFactory.createRiderRating();
        System.out.println("Rider Rated Successfully! Rating: " + rating + "/5");

    }

    public void updateLocation(String location) {
        this.location = location;
        System.out.println("Location Updated!");
    }

    public void startTrip(){
        this.availability = false;
        System.out.println("Trip Started!");
    }

    public void endTrip(){
        this.availability = true;
        System.out.println("Trip Ended!");
    }
}
