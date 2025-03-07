package Adapter;
import Adaptee_Different_API.FacebookAPI;
import Adapter.INotification;

public class FacebookNotificationAdapter implements INotification {
    FacebookAPI facebookAPI;

    public FacebookNotificationAdapter(FacebookAPI facebookAPI) {
        this.facebookAPI = facebookAPI;
    }

    @Override
    public void markAsRead() {
        facebookAPI.markPostAsRead();
    }

    @Override
    public void markAsUnread() {
        facebookAPI.markPostAsUnread();
    }

    @Override
    public void deleteNotification() {
        facebookAPI.deletePostNotification();
    }
}
