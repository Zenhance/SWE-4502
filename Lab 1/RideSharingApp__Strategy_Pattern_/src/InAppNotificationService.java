public class InAppNotificationService implements INotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("In-App Notification: " + message);
    }
}

