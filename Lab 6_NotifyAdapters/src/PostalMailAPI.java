public class PostalMailAPI {
    public void sendPostalMail(String recipientName, String address, String postalCode, String message) {
        System.out.println("Sending Postal Mail to " + recipientName + " at " + address + ", " + postalCode + ": " + message);
    }
}
