using System.Collections.Generic;

namespace Lab_7_SoGossip
{
    public class FacebookFacade
    {
        public List<INotification> GetNotifications()
        {
            return new List<INotification>
            {
                new FacebookNotification("You have a new friend request."),
                new FacebookNotification("Happy birthday!"),
                new FacebookNotification("New comment on your post.")
            };
        }
    }
}
