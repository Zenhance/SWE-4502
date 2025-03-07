using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_7_SoGossip
{
    public class TwitterNotification : INotification
    {
        private string _content;

        public TwitterNotification(string content)
        {
            _content = content;
        }

        public string Content => _content;

        public void MarkAsRead() => Console.WriteLine("Twitter notification marked as read.");
        public void MarkAsUnread() => Console.WriteLine("Twitter notification marked as unread.");
        public void Delete() => Console.WriteLine("Twitter notification deleted.");
    }

}
