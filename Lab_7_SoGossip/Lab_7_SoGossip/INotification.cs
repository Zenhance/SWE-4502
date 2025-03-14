using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_7_SoGossip
{
    public interface INotification
    {
        string Content { get; }
        void MarkAsRead();
        void MarkAsUnread();
        void Clear();
    }

}
