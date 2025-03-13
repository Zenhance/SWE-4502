using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IRemoteController
    {
        void DisplayCurrentState();
        void GenerateNotifications(string message);
        void ControlSystem(string command);
    }
}
