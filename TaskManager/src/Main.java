public class Main {
    public static void main(String[] args) {
        IssueRepository issueRepository = new IssueRepository();
        NotificationService notificationService = new NotificationService();
        CommandInvoker invoker = new CommandInvoker();
        Issue issue1 = new Issue("1", "Sample Issue", "Description", Priority.HIGH, "John Doe");
        CreateIssueCommand createCommand = new CreateIssueCommand(issueRepository, issue1);
        invoker.executeCommand(createCommand);
        EmailObserver emailObserver = new EmailObserver("user@example.com");
        notificationService.registerObserver(emailObserver);
        notificationService.notifyObservers("New issue created: " + issue1.getTitle());
    }
}