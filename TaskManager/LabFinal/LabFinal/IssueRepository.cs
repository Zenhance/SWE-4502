namespace LabFinal
{
    public class IssueRepository
    {
        private readonly Dictionary<int, Issue> _issues = new Dictionary<int, Issue>();

        public void AddIssue(Issue issue)
        {
            _issues[issue.Id] = issue;
        }

        public void RemoveIssue(int issueId)
        {
            _issues.Remove(issueId);
        }

        public void UpdateIssue(Issue issue)
        {
            _issues[issue.Id] = issue;
        }

        public Issue GetIssue(int issueId)
        {
            return _issues[issueId];
        }

        public IEnumerable<Issue> GetAllIssues()
        {
            return _issues.Values;
        }
    }
}