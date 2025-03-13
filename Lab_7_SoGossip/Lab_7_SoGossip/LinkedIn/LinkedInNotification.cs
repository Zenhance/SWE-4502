using System;

namespace Lab_7_SoGossip
{
    public class LinkedInNotification : INotification
    {
        public string Content { get; private set; }

        public LinkedInNotification(string content)
        {
            Content = content;
        }

        public void MarkAsRead()
        {
            Console.WriteLine("LinkedIn notification marked as read.");
        }

        public void MarkAsUnread()
        {
            Console.WriteLine("LinkedIn notification marked as unread.");
        }

        public void Clear()
        {
            Console.WriteLine("LinkedIn notification cleared.");
        }
    }
}
