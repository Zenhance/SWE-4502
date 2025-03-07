import Factory.*;
import Application.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ridoo App!");

        System.out.println("\nRegister Yourself as a Rider:");
        Rider rider = RiderFactory.crateRider();
        System.out.println("Rider Registered!");

        Trip currentTrip = rider.requestRide();

        currentTrip.driver.acceptRide();
        System.out.println("Trip Running...");
        Application.DemoSleep.sleep(2);
        currentTrip.driver.endTrip();
        rider.makePayment(currentTrip.fare);

        rider.rateDriver();
        currentTrip.driver.rateRider();

    }
}