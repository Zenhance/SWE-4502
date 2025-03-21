public interface Receiver {

    public void UpdateIssue(String description);

    public void Addcomments(Comment c);
    public void LogOperation();
    public void TriggerNotification();
    public void StatisticController();


}
