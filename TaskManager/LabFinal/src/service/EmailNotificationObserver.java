package service;

public class EmailNotificationObserver implements NotificationObserver {
    private final String email;

    public EmailNotificationObserver(String email) {
        this.email = email;
    }

    @Override
    public void onNotification(Notification notification) {
        // Simulate sending an email
        System.out.println("Sending email to " + email + ": " + notification.getMessage());
    }
}