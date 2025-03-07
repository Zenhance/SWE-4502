package Factory;

import Application.Trip;
import RideType.*;

import java.util.Scanner;
import java.util.Random;

public class TripFactory {

    private static int TripID = 0;
    public static Trip createTrip(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which type of trip do you want to take?");
        System.out.println("1. Bike Trip");
        System.out.println("2. Car Trip on Pool");
        System.out.println("3. Car Trip - Luxery");

        int choice = scanner.nextInt();

        RideType rideType = choseRideType(choice);

        System.out.println("Enter Start Location: ");
        String startLocation = scanner.next();
        System.out.println("Enter End Location: ");
        String endLocation = scanner.next();

        TripID++;
        return new Trip(TripID, startLocation, endLocation, rideType, 0, true);
    }

    private static RideType choseRideType(int choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case 1:
                int randomNumeberBetween1And10 = new Random().nextInt(10) + 1;
                int randomNumeberBetween20And300 = new Random().nextInt(300) + 20;
                return new BikeRide(randomNumeberBetween1And10, randomNumeberBetween20And300);
            case 2:
                int perHeadCost = new Random().nextInt(100) + 10;
                int numberOfPassengers = new Random().nextInt(5) + 1;
                return new CarPool(perHeadCost, numberOfPassengers);
            case 3:
                int hours = new Random().nextInt(5) + 1;
                int costPerhr = new Random().nextInt(100) + 10;
                return new LuxeryCar(hours, costPerhr);
            default:
                System.out.println("Invalid Choice");
                return null;
        }
    }
}
