public class SMSNotification implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
