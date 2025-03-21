public class TaskManager {
    private final IssueRepository repository;
    private final TaskManagerMediator mediator;

    public TaskManager() {
        this.repository = new IssueRepository();
        this.mediator = new TaskManagerMediator();
    }

    public Issue createIssue(String title, String description, Priority priority) {
        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setDescription(description);
        issue.setPriority(priority);

        CreateIssueCommand command = new CreateIssueCommand(repository, issue);
        mediator.executeCommand(command);

        return issue;
    }

    public void updateIssue(Issue issue) {
        UpdateIssueCommand command = new UpdateIssueCommand(repository, issue.getId(), issue);
        mediator.executeCommand(command);
    }

    public void changeIssueStatus(String issueId, Status newStatus) {
        ChangeIssueStatusCommand command = new ChangeIssueStatusCommand(repository, issueId, newStatus);
        mediator.executeCommand(command);
    }

    public void addComment(String issueId, String content, String author) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthor(author);

        AddCommentCommand command = new AddCommentCommand(repository, issueId, comment);
        mediator.executeCommand(command);
    }

    public void registerObserver(Observer observer) {
        mediator.getNotificationService().registerObserver(observer);
    }

    public void removeObserver(Observer observer) {
        mediator.getNotificationService().removeObserver(observer);
    }

    public void undo() {
        mediator.undoCommand();
    }

    public void redo() {
        mediator.redoCommand();
    }

    public Issue getIssue(String issueId) {
        return repository.getIssue(issueId);
    }

    public CommandManager getCommandManager() {
        return mediator.getCommandManager();
    }

    public OperationLogger getLogger() {
        return mediator.getLogger();
    }

    public StatisticsCollector getStatisticsCollector() {
        return mediator.getStatisticsCollector();
    }

    public NotificationService getNotificationService() {
        return mediator.getNotificationService();
    }
}
