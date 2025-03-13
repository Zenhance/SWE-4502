using System;

namespace Lab_7_SoGossip
{
    public class FacebookNotification : INotification
    {
        public string Content { get; private set; }

        public FacebookNotification(string content)
        {
            Content = content;
        }

        public void MarkAsRead()
        {
            Console.WriteLine("Facebook notification marked as read.");
        }

        public void MarkAsUnread()
        {
            Console.WriteLine("Facebook notification marked as unread.");
        }

        public void Clear()
        {
            Console.WriteLine("Facebook notification cleared.");
        }
    }
}
