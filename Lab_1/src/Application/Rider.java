package Application;

import Payment.Payment;

import Factory.PaymentFactory;
import Factory.RatingFactory;
import Factory.TripFactory;

import Payment.Payment;

public class Rider {
    public int id;
    public String name;
    public String location;
    public double rating;
    public Payment preferedMethod;

    public Rider(int id, String name, String location, double rating, Payment preferedMethod){
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.preferedMethod = preferedMethod;
    }

    public Rider(int id, String name, String location, Payment preferedMethod){
        this.id = id;
        this.name = name;
        this.location = location;
        this.preferedMethod = preferedMethod;
    }


    public Trip requestRide(){
        System.out.println("Requesting A Trip!");
        Trip trip = TripFactory.createTrip();
        Application.DemoSleep.sleep(2);
        System.out.println("Trip Requested! Assigning Driver...");
        Application.DemoSleep.sleep(3);
        trip.assignDriver();
        Application.DemoSleep.sleep(1);
        System.out.println("Driver Assigned! Driver Name: " + trip.driver.name);
        return trip;
    }

    public void rateDriver(){
        double rating = RatingFactory.createDriverRating();
        System.out.println("Driver Rated Successfully! Rating: " + rating + "/5");
        System.out.println("Thanks for the trip!");
    }

    public void makePayment(double amount){


        Payment payment = PaymentFactory.secondChoice(this);
        Application.DemoSleep.sleep(2);
        System.out.println("Processing Payment...");
        Application.DemoSleep.sleep(3);
        payment.pay(amount);
    }

}
