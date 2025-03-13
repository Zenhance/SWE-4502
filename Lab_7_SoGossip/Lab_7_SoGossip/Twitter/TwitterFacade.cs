using System;
using System.Collections.Generic;

namespace Lab_7_SoGossip
{
    public class TwitterFacade
    {
        public List<INotification> GetNotifications()
        {
            // Simulate fetching notifications from Twitter API
            return new List<INotification>
            {
                new TwitterNotification("New follower on Twitter."),
                new TwitterNotification("New mention in a tweet."),
                new TwitterNotification("A tweet got a reply.")
            };
        }
    }
}
