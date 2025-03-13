package Adapter;

import Adaptee_Different_API.LinkedInAPI;
import Adapter.INotification;

public class LinkedInNotificationAdapter implements INotification {
    LinkedInAPI linkedInAPI;

    public LinkedInNotificationAdapter(LinkedInAPI linkedInAPI) {
        this.linkedInAPI = linkedInAPI;
    }

    @Override
    public void markAsRead() {
        linkedInAPI.markMessageAsRead();
    }

    @Override
    public void markAsUnread() {
        linkedInAPI.markMessageAsUnread();
    }

    @Override
    public void deleteNotification() {
        linkedInAPI.deleteMessageNotification();
    }
}
