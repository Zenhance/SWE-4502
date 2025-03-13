using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    // Common interface for all notifications
    public interface INotification
    {
        void Send(string to, string message);
    }

}
