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

            if(issues.ContainsKey(id))
            {
                return issues[id];
            }

            else
            {
                return null;
            }
        }   

        public void UpdateIssue(Issue issue)
        {
            if (issues.ContainsKey(issue.Id))
            {
                issues[issue.Id] = issue;
            }
        }

        public void DeleteIssue(int id)
        {
            issues.Remove(id);
        }

        public List<Issue> GetAllIssues()
        {
            return new List<Issue>(issues.Values);
        }
    }
}
