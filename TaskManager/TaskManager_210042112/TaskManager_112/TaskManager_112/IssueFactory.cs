using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public static class IssueFactory
    {
        public static Issue CreateIssue(int id, string title, string description, Priority priority)
        {
            return new Issue(id, title, description, priority);
        }
    }
}
