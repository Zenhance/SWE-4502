package Lab_Final_210042150.Unit_Test;

import Lab_Final_210042150.Task_Management_System.Command.CommandManager;
import Lab_Final_210042150.Task_Management_System.Enums.Priority;
import Lab_Final_210042150.Task_Management_System.Enums.Status;
import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;
import Lab_Final_210042150.Task_Management_System.Observer_Pattern.EmailNotification;
import Lab_Final_210042150.Task_Management_System.Observer_Pattern.NotificationObserver;
import Lab_Final_210042150.Task_Management_System.Observer_Pattern.NotificationService;
import Lab_Final_210042150.Task_Management_System.Repositories.IssueRepository;
import Lab_Final_210042150.Task_Management_System.Services.LoggingServices;
import Lab_Final_210042150.Task_Management_System.Services.StatisticsService;
import Lab_Final_210042150.Task_Management_System.Services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskManagertest {
    private IssueRepository repository;
    private LoggingServices loggingService;
    private CommandManager commandManager;
    private NotificationService notificationService;
    private StatisticsService statisticsService;
    private TaskService taskManager;

    private NotificationObserver observer1;
    private NotificationObserver observer2;

    @BeforeEach
    public void setup()
    {
        repository = new IssueRepository();
        loggingService = new LoggingServices();
        commandManager = new CommandManager(loggingService);
        notificationService = new EmailNotification();
        statisticsService = new StatisticsService();
        taskManager = new TaskService(repository, commandManager, notificationService, statisticsService);

        observer1 = new NotificationObserver() {
            @Override
            public void onIssueCreated(Issue issue) {

            }

            @Override
            public void onIssueUpdated(Issue oldIssue, Issue newIssue) {

            }
        };
        observer2 = new NotificationObserver() {
            @Override
            public void onIssueCreated(Issue issue) {

            }

            @Override
            public void onIssueUpdated(Issue oldIssue, Issue newIssue) {

            }
        };
        notificationService.registerObserver(observer1);
    }

    @Test
    public void createIssue_ShouldAddIssueToRepository()
    {
        Issue issue = taskManager.createIssue("Test Issue", "Description for test issue", Priority.Medium);

        Optional<Issue> retrievedIssue = taskManager.getIssue(issue.getId());
        assertTrue(retrievedIssue.isPresent());
        assertEquals("Test Issue", retrievedIssue.get().getTitle());
        assertEquals("Description for test issue", retrievedIssue.get().getDescription());
        assertEquals(Priority.Medium, retrievedIssue.get().getPriority());
        assertEquals(Status.Open, retrievedIssue.get().getStatus());
    }

}
