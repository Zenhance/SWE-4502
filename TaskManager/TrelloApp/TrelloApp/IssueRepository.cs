using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrelloApp
{
    public class IssueRepository
    {
        public Issue issue;
        public Dictionary<int, Issue> issues = new Dictionary<int, Issue>();

        public IssueRepository(Issue issue) 
        {
            this.issue = issue;
        }

        public void createIssue (Issue issue)
        {
            issues.Add(issue.id, issue);
        }

        public Issue getIssue (int issueid)
        {
            return issues[issueid];
        }

        public void updateIssue(Issue issue)
        {
            if (issues.ContainsKey(issue.id))
            {
                issues[issue.id] = issue;
            }
        }
    }
}
