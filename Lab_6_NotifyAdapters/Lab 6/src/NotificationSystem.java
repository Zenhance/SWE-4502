public class NotificationSystem {
    public static void main(String[] args) {
        NotificationSender emailNotification = new EmailNotification();
        NotificationSender smsNotification = new SMSNotification();

        PostalMailAPI postalMailAPI = new PostalMailAPI();
        NotificationSender postalMailAdapter = new PostalMailAdapter(postalMailAPI);

        emailNotification.send("alif999@gmail.com", "This is an email notification.");

        smsNotification.send("01775006277", "This is an SMS notification.");

        postalMailAdapter.send("Alif,1500", "This is a postal mail notification.");
    }
}
