package notification;

import command.Command;
import command.CommandObserver;

public class NotificationService implements CommandObserver {
    private static NotificationService instance;

    private int notificationCount;

    private NotificationService() {
        notificationCount = 0;
    }

    public static synchronized NotificationService getInstance() {
        if (instance == null) {

            instance = new NotificationService();
        }
        return instance;
    }

    @Override
    public void update(Command command) {

        sendNotification("Updated" + command.getDescription() + " at " + command.getTimestamp());
    }

    private void sendNotification(String message) {

        System.out.println("NOTIFICATION: " + message);
        notificationCount++;
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}