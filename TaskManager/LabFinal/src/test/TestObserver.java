package test;

import service.Notification;
import service.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

class TestObserver implements NotificationObserver {
    private final List<Notification> notifications = new ArrayList<>();

    @Override
    public void onNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public int getNotificationCount() {
        return notifications.size();
    }

    public void clearNotifications() {
        notifications.clear();
    }
}