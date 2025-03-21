using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using global::TaskManager.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace TaskManager.Repository
{
        public class IssueRepository
        {
            private readonly Dictionary<Guid, Issue> _issues;

            public IssueRepository()
            {
                _issues = new Dictionary<Guid, Issue>();
            }

            public void Add(Issue issue)
            {
                _issues[issue.Id] = issue;
            }

            public void Update(Issue issue)
            {
                if (_issues.ContainsKey(issue.Id))
                {
                    _issues[issue.Id] = issue;
                }
                else
                {
                    throw new KeyNotFoundException($"Issue with ID {issue.Id} not found.");
                }
            }

            public void Remove(Guid id)
            {
                if (_issues.ContainsKey(id))
                {
                    _issues.Remove(id);
                }
                else
                {
                    throw new KeyNotFoundException($"Issue with ID {id} not found.");
                }
            }

            public Issue GetById(Guid id)
            {
                if (_issues.ContainsKey(id))
                {
                    return _issues[id];
                }
                throw new KeyNotFoundException($"Issue with ID {id} not found.");
            }

            public IEnumerable<Issue> GetAll()
            {
                return _issues.Values.ToList();
            }
        }
}