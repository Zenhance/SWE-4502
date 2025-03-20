using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class IssueRepository
    {

        private Dictionary<int, Issue> repository = new Dictionary<int, Issue>();


        public void addIssue(Issue issue)
        {
            repository[issue.Id] = issue;
        }
        public void removeIssue(int id)
        {
            repository.Remove(id);
        }



    }
}
