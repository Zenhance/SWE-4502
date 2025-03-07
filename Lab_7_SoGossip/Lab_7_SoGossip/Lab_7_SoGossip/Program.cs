using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_7_SoGossip
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Create the Social Media Aggregator
            var aggregator = new SocialMediaAggregator();

            // Simulate notifications from different platforms
            List<INotification> twitterNotifications = new List<INotification>
        {
            new TwitterNotification("New tweet from a friend."),
            new TwitterNotification("Someone liked your tweet.")
        };

            List<INotification> facebookNotifications = new List<INotification>
        {
            new TwitterNotification("New comment on your post."),
            new TwitterNotification("You have a new friend request.")
        };

            // Add notifications to the aggregator
            aggregator.AddNotifications(twitterNotifications);
            aggregator.AddNotifications(facebookNotifications);

            // Display and interact with notifications through the facade
            aggregator.DisplayAllNotifications();
            aggregator.MarkAllAsRead();
            aggregator.DeleteAll();
            Console.ReadLine();
        }
    }
}
