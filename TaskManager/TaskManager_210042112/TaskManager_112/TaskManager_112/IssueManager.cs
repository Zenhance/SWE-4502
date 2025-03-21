using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class IssueManager
    {
        public List<IObserver> obs = new List<IObserver>();

        public void Attach(IObserver observer)
        {
            obs.Add(observer);
        }

        public void Detach(IObserver observer)
        {
            obs.Remove(observer);
        }

        public void Notify(string msg)
        {
            foreach(var ob in obs)
            {
                ob.Update(msg);
            }

        }
    }
}
