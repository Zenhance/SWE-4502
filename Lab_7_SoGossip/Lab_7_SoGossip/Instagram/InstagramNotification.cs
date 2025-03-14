using System;

namespace Lab_7_SoGossip
{
    public class InstagramNotification : INotification
    {
        public string Content { get; private set; }

        public InstagramNotification(string content)
        {
            Content = content;
        }

        public void MarkAsRead()
        {
            Console.WriteLine("Instagram notification marked as read.");
        }

        public void MarkAsUnread()
        {
            Console.WriteLine("Instagram notification marked as unread.");
        }

        public void Clear()
        {
            Console.WriteLine("Instagram notification cleared.");
        }
    }
}
