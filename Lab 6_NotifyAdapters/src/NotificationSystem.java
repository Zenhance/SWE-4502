public class NotificationSystem {
    public static void main(String[] args) {
        NotificationSender emailNotification = new EmailNotification();
        NotificationSender smsNotification = new SMSNotification();

        PostalMailAPI postalMailAPI = new PostalMailAPI();
        NotificationSender postalMailAdapter = new PostalMailAdapter(postalMailAPI);

        emailNotification.send("rifafr95@gmail.com", "This is an email notification.");

        smsNotification.send("01875602306", "This is an SMS notification.");

        postalMailAdapter.send("Rifaf,Dhanmondi,1200", "This is a postal mail notification.");
    }
}
