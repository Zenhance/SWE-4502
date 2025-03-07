public class Main {
    public static void main(String[] args) {
        // Sending email notification
        Notification emailNotification = new EmailNotification();
        NotificationSender emailSender = new NotificationSender(emailNotification);
        emailSender.sendNotification("This message is for email.");

        // Sending SMS notification
        Notification smsNotification = new SMSNotification();
        NotificationSender smsSender = new NotificationSender(smsNotification);
        smsSender.sendNotification("This message is for sms.");

        // Sending postal mail notification using 3rd party API
        Notification postalMailNotification = new PostalMailNotification("Banasree,Rampura", "Tauhid");
        NotificationSender postalMailSender = new NotificationSender(postalMailNotification);
        postalMailSender.sendNotification("Valo Thaikko baap.");
    }
}
