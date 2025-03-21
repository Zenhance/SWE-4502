using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class IssueRepository
    {
        Dictionary<int, Issue> issues = new Dictionary<int, Issue>();

        public void CreateIssue(Issue issue)
        {
            issues.Add(issue.ID, issue);
        }

        public Issue GetIssue(int id)
        {
            return issues.ContainsKey(id) ? issues[id] : null; // does the dictionary contain the id or not
        }
    }
}
