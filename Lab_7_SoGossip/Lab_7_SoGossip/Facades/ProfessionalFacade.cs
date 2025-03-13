using System;
using System.Collections.Generic;

namespace Lab_7_SoGossip
{
    internal class ProfessionalFacade
    {
        private TwitterFacade twitterFacade;
        private LinkedInFacade linkedInFacade;

        public ProfessionalFacade(TwitterFacade twitterFacade, LinkedInFacade linkedInFacade)
        {
            this.twitterFacade = twitterFacade;
            this.linkedInFacade = linkedInFacade;
        }

        public void ClearJobAndConnectionNotifications()
        {
            Console.WriteLine("Clearing job and connection-related notifications across platforms...");

            foreach (var notification in twitterFacade.GetNotifications())
            {
                if (notification.Content.Contains("job") || notification.Content.Contains("connection"))
                {
                    notification.Clear(); 
                }
            }

            foreach (var notification in linkedInFacade.GetNotifications())
            {
                if (notification.Content.Contains("job") || notification.Content.Contains("connection"))
                {
                    notification.Clear();  
                }
            }
        }

        public void MarkAllAsRead()
        {
            foreach (var notification in twitterFacade.GetNotifications())
            {
                notification.MarkAsRead();
            }

            foreach (var notification in linkedInFacade.GetNotifications())
            {
                notification.MarkAsRead();
            }
        }

        public void MarkAllAsUnread()
        {
            foreach (var notification in twitterFacade.GetNotifications())
            {
                notification.MarkAsUnread();
            }

            foreach (var notification in linkedInFacade.GetNotifications())
            {
                notification.MarkAsUnread();
            }
        }

        public void ClearAllNotifications()
        {
            foreach (var notification in twitterFacade.GetNotifications())
            {
                notification.Clear();
            }

            foreach (var notification in linkedInFacade.GetNotifications())
            {
                notification.Clear();
            }
        }
    }
}
