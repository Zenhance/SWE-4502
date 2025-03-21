public class IssueMediator {
    public IssueRepository issueRepository;
    public NotificationService notificationservice;

    public IssueMediator(IssueRepository issueRepository, NotificationService notificationservice){
        this.issueRepository = issueRepository;
        this.notificationservice = notificationservice;
    }

    public void notifyService(String event){
        notificationservice.update(event);
    }
}
