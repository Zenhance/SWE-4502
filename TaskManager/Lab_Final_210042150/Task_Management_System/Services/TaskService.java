package Lab_Final_210042150.Task_Management_System.Services;

import Lab_Final_210042150.Task_Management_System.Command.CommandManager;
import Lab_Final_210042150.Task_Management_System.Command.CreateIssueCommand;
import Lab_Final_210042150.Task_Management_System.Enums.Priority;
import Lab_Final_210042150.Task_Management_System.Interfaces.Command;
import Lab_Final_210042150.Task_Management_System.Models.CommentModel.Comment;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;
import Lab_Final_210042150.Task_Management_System.Observer_Pattern.NotificationService;
import Lab_Final_210042150.Task_Management_System.Repositories.IssueRepository;

import java.util.Collection;
import java.util.Optional;

public class TaskService {
    private final IssueRepository repository;
    private final CommandManager commandManager;
    private final NotificationService notificationService;
    private final StatisticsService statisticsService;

    public TaskService(IssueRepository repository,
                              CommandManager commandManager,
                              NotificationService notificationService,
                              StatisticsService statisticsService) {
        this.repository = repository;
        this.commandManager = commandManager;
        this.notificationService = notificationService;
        this.statisticsService = statisticsService;
    }

    public Issue createIssue(String title, String description, Priority priority) {
        Issue issue = new Issue(title, description, priority);
        Command command = new CreateIssueCommand(issue, repository);
        commandManager.executeCommand(command);
        return issue;
    }

    public Optional<Issue> getIssue(String id) {
        return repository.findById(id);
    }

    public Collection<Issue> getAllIssues() {
        return repository.findAll();
    }

    public void undo() {
        commandManager.undo();
    }

    public void redo() {
        commandManager.redo();
    }

    public boolean canUndo() {
        return commandManager.canUndo();
    }

    public boolean canRedo() {
        return commandManager.canRedo();
    }

}
