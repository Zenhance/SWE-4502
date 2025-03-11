import Adaptee_Different_API.TwitterAPI;
import Adaptee_Different_API.FacebookAPI;
import Adaptee_Different_API.LinkedInAPI;
import Adaptee_Different_API.InstagramAPI;
import Adapter.INotification;
import Adapter.TwitterNotificationAdapter;
import Adapter.LinkedInNotificationAdapter;
import Adapter.FacebookNotificationAdapter;
import Adapter.InstagramNotificationAdapter;

public class NotificationFacade
{
    private INotification twitterNotification;
    private INotification facebookNotification;
    private INotification linkedInNotification;
    private INotification instagramNotification;

    public NotificationFacade(TwitterAPI twitterAPI, FacebookAPI facebookAPI, LinkedInAPI linkedInAPI, InstagramAPI instagramAPI) {
        twitterNotification = new TwitterNotificationAdapter(twitterAPI);
        facebookNotification = new FacebookNotificationAdapter(facebookAPI);
        linkedInNotification = new LinkedInNotificationAdapter(linkedInAPI);
        instagramNotification = new InstagramNotificationAdapter(instagramAPI);
    }

    public void markAllAsRead() {
        twitterNotification.markAsRead();
        facebookNotification.markAsRead();
        linkedInNotification.markAsRead();
        instagramNotification.markAsRead();
    }

    public void markAllAsUnread() {
        twitterNotification.markAsUnread();
        facebookNotification.markAsUnread();
        linkedInNotification.markAsUnread();
        instagramNotification.markAsUnread();
    }

    public void deleteAllNotifications() {
        twitterNotification.deleteNotification();
        facebookNotification.deleteNotification();
        linkedInNotification.deleteNotification();
        instagramNotification.deleteNotification();
    }

}
