using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class IssueRepository
    {
        private Dictionary<int, Issue> issues = new Dictionary<int, Issue>();

        public void AddIssue(Issue issue)
        {
            issues[issue.Id] = issue;
        }

        public Issue GetIssue(int id)
        {
            return issues.ContainsKey(id) ? issues[id] : null;
        }

        public void UpdateIssue(Issue issue)
        {
            if (issues.ContainsKey(issue.Id))
            {
                issues[issue.Id] = issue;
            }
        }
    }
}
