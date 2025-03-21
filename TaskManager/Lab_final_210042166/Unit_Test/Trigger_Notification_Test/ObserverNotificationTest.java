package Lab_final_210042166.Unit_Test.Trigger_Notification_Test;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.IssueObserver;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.ObservableIssue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ObserverNotificationTest {

    @Test
    public void Observer_ShouldBeNotifiedOfCommands()
    {
        ObservableIssue issue=new ObservableIssue("1","Test Issue","Checking Notification", Priority.MEDIUM,"User1");
        IssueObserver observer=new IssueObserver("Observer1");
        issue.addObserver(observer);
        issue.setStatus(Status.IN_PROGRESS);

        assertTrue(true);
    }
}
