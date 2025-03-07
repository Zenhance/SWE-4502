public class NotificationSender {
    private Notification notification;


    public NotificationSender(Notification notification) {
        this.notification = notification;
    }


    public void sendNotification(String message) {
        notification.send(message);
    }
}
