package test;

import model.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.NotificationType;
import taskmanager.TaskManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObserverNotificationTest
{
    private TaskManager taskManager;
    private TestObserver testObserver;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        testObserver = new TestObserver();
        taskManager.registerObserver(testObserver);
    }

    //#F06
    @Test
    void observer_ShouldBeNotifiedOfCommands() {
        taskManager.createIssue("Observer Test", "Testing notifications", Priority.High);

        Assertions.assertEquals(1, testObserver.getNotificationCount());
        Assertions.assertEquals(NotificationType.ISSUE_CREATED, testObserver.getNotifications().get(0).getType());
    }


}
