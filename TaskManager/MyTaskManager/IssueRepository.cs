using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class IssueRepository
    {
        public Dictionary<int, Issue> issues;
        public int nextIssueId;
        public int nextCommentId;

        public IssueRepository()
        {
            issues = new Dictionary<int, Issue>();
            nextIssueId = 1;
            nextCommentId = 1;
        }

        public int GetNextIssueId()
        {
            return nextIssueId++;
        }

        public int GetNextCommentId()
        {
            return nextCommentId++;
        }

        public void AddIssue(Issue issue)
        {
            issues[issue.Id] = issue;
        }

        public Issue GetIssue(int id)
        {
            if (issues.ContainsKey(id)) return issues[id];
            return null;
        }

        public void UpdateIssue(Issue issue)
        {
            if (issues.ContainsKey(issue.Id))
            {
                issues[issue.Id] = issue;
            }
        }

        public Dictionary<int, Issue> GetAllIssues()
        {
            return issues;
        }
    }
}
