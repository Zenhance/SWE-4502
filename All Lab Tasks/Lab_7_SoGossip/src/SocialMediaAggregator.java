import Adaptee_Different_API.FacebookAPI;
import Adaptee_Different_API.InstagramAPI;
import Adaptee_Different_API.LinkedInAPI;
import Adaptee_Different_API.TwitterAPI;

public class SocialMediaAggregator
{
    public static void main(String[] args) {
        TwitterAPI twitterAPI = new TwitterAPI();
        FacebookAPI facebookAPI = new FacebookAPI();
        LinkedInAPI linkedInAPI = new LinkedInAPI();
        InstagramAPI instagramAPI = new InstagramAPI();

        NotificationFacade notificationFacade = new NotificationFacade(twitterAPI, facebookAPI, linkedInAPI, instagramAPI);

        notificationFacade.markAllAsRead();
        notificationFacade.markAllAsUnread();
        notificationFacade.deleteAllNotifications();

    }

}
