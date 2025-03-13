package Adapter;
import Adaptee_Different_API.TwitterAPI;
import Adapter.INotification;

public class TwitterNotificationAdapter implements INotification
{
    TwitterAPI twitterAPI;

    public TwitterNotificationAdapter(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public void markAsRead() {
        twitterAPI.markTweetAsSeen();
    }

    @Override
    public void markAsUnread() {
        twitterAPI.markTweetAsUnseen();
    }

    @Override
    public void deleteNotification() {
        twitterAPI.removeTweetNotification();
    }


}
