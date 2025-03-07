import java.util.List;
import java.util.Scanner;

public class Rider {
    private int id;
    private String name;
    private String location;
    private double rating;
    private PaymentMethod preferredPaymentMethod;

    private int trips;

    public Rider(int id, String name, PaymentMethod preferredPaymentMethod) {
        this.id = id;
        this.name = name;
        this.rating = 0;
        this.location = getlocation();
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public Trip requestRide(String pickupLocation, String dropOffLocation ,RideType rideType) {
        return new Trip(this,pickupLocation,dropOffLocation,rideType);
    }

    public void rateDriver(Driver driver, double rating) {
        double getRating = driver.getRating();
        int getTrips= driver.getTrips();

        double totalRating = getTrips*getRating + rating;
        int totalTrips = getTrips+1;
        driver.setTrips(totalTrips);

        driver.setRating(totalRating/totalTrips);
    }

    public void setPreferredPaymentMethod(PaymentMethod preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public void makePayment(double amount) {
        preferredPaymentMethod.processPayment(amount);
    }
    public String getlocation() {
        location = "Getting Live location";
        return location;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips){
        this.trips = trips;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    void changePaymentMethod(){
        System.out.println("------------------------");
        System.out.println("Choose Preferred Payment Method: ");
        System.out.println("1. PayPal");
        System.out.println("2. Credit Card");
        System.out.println("3. Digital Wallet");

        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        int choice = Integer.parseInt(scan);

        switch (choice) {
            case 1:
                System.out.print("Enter your Paypal Email: ");
                String email = scanner.nextLine();
                PayPal payPal = new PayPal(email);
                setPreferredPaymentMethod(payPal);
                System.out.println("Preferred Payment Method changed to PayPal");
                break;

            case 2:
                PaymentMethod cardPayment = new CreditCard("4321-5678-9876-5432", "Mehedi", "12/25", 123);
                setPreferredPaymentMethod(cardPayment);
                System.out.println("Preferred Payment Method changed to Credit Card");
                break;

            case 3:
                System.out.print("Enter your Wallet Id: ");
                String id = scanner.nextLine();
                DigitalWallet wallet = new DigitalWallet(id);
                setPreferredPaymentMethod(wallet);
                System.out.println("Preferred Payment Method changed to Digital Wallet");
                break;

            default:
                System.out.println("Invalid");
                break;
        }

    }
}
