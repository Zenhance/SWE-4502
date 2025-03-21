package taskmanager;
import command.*;
import model.Issue;
import model.Priority;
import model.Status;
import repository.IssueRepository;
import service.*;
import java.util.List;

public class TaskManager {
    private final IssueRepository repository;
    private final CommandHistory commandHistory;
    private final LogService logService;
    private final NotificationService notificationService;
    private final StatisticsService statisticsService;

    public TaskManager() {
        this.repository = new IssueRepository();
        this.commandHistory = new CommandHistory();
        this.logService = new LogService();
        this.notificationService = new NotificationService();
        this.statisticsService = new StatisticsService();
    }

    public void registerObserver(NotificationObserver observer) {
        notificationService.addObserver(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        notificationService.removeObserver(observer);
    }

    public String createIssue(String title, String description, Priority priority) {
        CreateIssueCommand command = new CreateIssueCommand(
                repository, title, description, priority, notificationService);
        executeCommand(command);
        return command.getIssueId();
    }

    public void updateIssue(String issueId, String title, String description,
                            Priority priority, String assignedTo) {
        UpdateIssueCommand command = new UpdateIssueCommand(
                repository, issueId, title, description, priority, assignedTo, notificationService);
        executeCommand(command);
    }

    public void changeStatus(String issueId, Status newStatus) {
        ChangeStatusCommand command = new ChangeStatusCommand(
                repository, issueId, newStatus, notificationService);
        executeCommand(command);
    }

    public void addComment(String issueId, String content, String author) {
        AddCommentCommand command = new AddCommentCommand(
                repository, issueId, content, author, notificationService);
        executeCommand(command);
    }

    private void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        logService.logCommand(command);
        statisticsService.trackCommand(command);
    }

    public boolean undo() {
        if (commandHistory.canUndo()) {
            Command command = commandHistory.pop();
            command.undo();
            logService.logCommand(new UndoLogCommand(command));
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (commandHistory.canRedo()) {
            Command command = commandHistory.redoCommand();
            command.execute();
            logService.logCommand(new RedoLogCommand(command));
            return true;
        }
        return false;
    }

    public Issue getIssue(String issueId) {
        return repository.findById(issueId);
    }
    public List<Issue> getAllIssues() {
        return repository.findAll();
    }
    public LogService getLogService() {
        return logService;
    }
    public StatisticsService getStatisticsService() {
        return statisticsService;
    }

}