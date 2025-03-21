using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class IssueObserver : IObserver
    {
        private string Name;
        public IssueObserver(string name)
        {
            Name = name;
        }
        public void Update(string msg)
        {
            Console.WriteLine(Name + "has been notified with: " + msg);
        }
    }
}
