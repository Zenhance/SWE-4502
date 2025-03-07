using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_7_SoGossip
{
    public class SocialMediaAggregator
    {
        private List<INotification> _notifications = new List<INotification>();

        public void AddNotifications(List<INotification> notifications)
        {
            _notifications.AddRange(notifications);
        }

        public void DisplayAllNotifications()
        {
            foreach (var notification in _notifications)
            {
                Console.WriteLine($"Notification: {notification.Content}");
            }
        }

        public void MarkAllAsRead()
        {
            foreach (var notification in _notifications)
            {
                notification.MarkAsRead();
            }
        }

        public void MarkAllAsUnread()
        {
            foreach (var notification in _notifications)
            {
                notification.MarkAsUnread();
            }
        }

        public void DeleteAll()
        {
            foreach (var notification in _notifications)
            {
                notification.Delete();
            }
            _notifications.Clear();
        }
    }

}
