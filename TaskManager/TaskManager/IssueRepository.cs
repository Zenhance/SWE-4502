using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class IssueRepository
    {
        public List<Issue> Issues = new List<Issue>();
        public List<Dictionary<string, string>> IssueHistory = new List<Dictionary<string, string>>();
        public void AddIssue(Issue issue)
        {
            Issues.Add(issue);
            Console.WriteLine("Issue created");
        }

        public void UpdateIssue(Issue issue)
        {
            Console.WriteLine("Issue updated");
        }

        public void ChangeIssueStatus(Issue issue, Status status)
        {
            Console.WriteLine("Issue status changed");
        }

        

    }
}
