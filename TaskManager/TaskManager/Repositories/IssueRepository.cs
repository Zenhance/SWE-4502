using System;
using System.Collections.Generic;
using TaskManager.Models;

namespace TaskManager.Repositories
{
    public class IssueRepository
    {
        private readonly Dictionary<int, Issue> _issues = new Dictionary<int, Issue>();
        private int _nextId = 1;

        public void AddIssue(Issue issue)
        {
            issue.Id = _nextId++;
            issue.CreationDate = DateTime.Now;
            issue.LastModifiedDate = DateTime.Now;
            _issues[issue.Id] = issue;}

        public Issue GetIssue(int id)
        {
            return _issues.ContainsKey(id) ? _issues[id] : null;
        }

        public void UpdateIssue(Issue issue)
        {
            issue.LastModifiedDate = DateTime.Now;
            _issues[issue.Id] = issue;
        }

        public IEnumerable<Issue> GetAllIssues()
        {
            return _issues.Values;  
        }
        }
}