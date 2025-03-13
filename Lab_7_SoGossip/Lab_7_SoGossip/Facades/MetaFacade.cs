using System;

namespace Lab_7_SoGossip
{
    internal class MetaFacade
    {
        private FacebookFacade facebookFacade;
        private InstagramFacade instagramFacade;

        public MetaFacade(FacebookFacade facebookFacade, InstagramFacade instagramFacade)
        {
            this.facebookFacade = facebookFacade;
            this.instagramFacade = instagramFacade;
        }

        // Clears birthday-related notifications from all platforms.
        public void ClearBirthdayNotifications()
        {
            Console.WriteLine("Clearing birthday notifications across platforms...");

            foreach (var notification in facebookFacade.GetNotifications())
            {
                if (notification.Content.Contains("birthday"))
                {
                    notification.Clear();  
                }
            }

            foreach (var notification in instagramFacade.GetNotifications())
            {
                if (notification.Content.Contains("birthday"))
                {
                    notification.Clear(); 
                }
            }
        }

        public void MarkAllAsRead()
        {
            foreach (var notification in facebookFacade.GetNotifications())
            {
                notification.MarkAsRead();
            }

            foreach (var notification in instagramFacade.GetNotifications())
            {
                notification.MarkAsRead();
            }
        }
    }
}
