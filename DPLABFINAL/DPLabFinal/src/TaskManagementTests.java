import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagementTests {

    private IssueRepository repository;
    private CommandInvoker invoker;
    private NotificationService notificationService;

    @BeforeEach
    public void setup()
    {
        repository= new IssueRepository();
        invoker=new CommandInvoker();
        notificationService=new NotificationService();
    }

    @Test
    public void CreateIssue_ShouldAddIssueToRepository






















}
