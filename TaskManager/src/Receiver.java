public interface Receiver {
    public void CreateIssue(IssueRepository r);
    public void UpdateIssue(String description);
    public void ChangeStatus(Priority p);
    public void Addcomments();
    public void LogOperation();
    public void TriggerNotification();
    public void StatisticController();


}
