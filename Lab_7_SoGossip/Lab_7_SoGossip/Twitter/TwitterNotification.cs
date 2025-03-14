using System;

namespace Lab_7_SoGossip
{
    public class TwitterNotification : INotification
    {
        public string Content { get; private set; }

        public TwitterNotification(string content)
        {
            Content = content;
        }

        public void MarkAsRead()
        {
            Console.WriteLine("Twitter notification marked as read.");
        }

        public void MarkAsUnread()
        {
            Console.WriteLine("Twitter notification marked as unread.");
        }

        public void Clear()
        {
            Console.WriteLine("Twitter notification cleared.");
        }
    }
}
