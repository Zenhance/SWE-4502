package Factory;

import Application.Rider;
import Payment.*;

import java.util.Scanner;
public class RiderFactory {
    public static int riderID = 0;
    public static Rider crateRider(){
        Scanner scanner = new Scanner(System.in);
        riderID++;
        System.out.println("Enter Rider Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Rider Location: ");
        String location = scanner.nextLine();
        System.out.println("Select Payment Method: ");
        Payment payment = PaymentFactory.createPayment();


        return new Rider(riderID, name, location, payment);
    }






}
