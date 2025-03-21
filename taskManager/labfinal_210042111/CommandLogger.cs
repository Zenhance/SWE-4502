using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class CommandLogger:IObserver
    {
        private List<string> logHistory = new List<string>();
      
        public void Update(string message)
        {
            logHistory.Add(message);
        }
        public List<string> getLogHistory()
        {
            return logHistory;
        }
    }
}
