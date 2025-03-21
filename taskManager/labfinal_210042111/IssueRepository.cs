using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class IssueRepository
    {

        private Dictionary<int, Issue> repository = new Dictionary<int, Issue>();

        public IssueRepository(int id, Issue i)
        {
            repository.Add(id, i);
           
        }
        public void addIssue(Issue issue)
        {
            repository[issue.Id] = issue;
        }

           
        public void removeIssue(int id)
        {
            repository.Remove(id);
        }

        public Issue getIssue(int id)
        {
            return repository.ContainsKey(id) ? repository[id] : null;

        }

        public bool Contains(int id)=>repository.ContainsKey(id);
        public IEnumerable<Issue> GetAll() => repository.Values;


    }
}
