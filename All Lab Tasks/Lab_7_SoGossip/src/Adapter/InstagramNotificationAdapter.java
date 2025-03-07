package Adapter;
import Adaptee_Different_API.InstagramAPI;
import Adapter.INotification;

public class InstagramNotificationAdapter implements INotification
{
    InstagramAPI instagramAPI;

    public InstagramNotificationAdapter(InstagramAPI instagramAPI) {
        this.instagramAPI = instagramAPI;
    }

    @Override
    public void markAsRead() {
        instagramAPI.markStoryAsSeen();
    }

    @Override
    public void markAsUnread() {
        instagramAPI.markStoryAsUnseen();
    }

    @Override
    public void deleteNotification() {
        instagramAPI.deleteStoryNotification();
    }
}
