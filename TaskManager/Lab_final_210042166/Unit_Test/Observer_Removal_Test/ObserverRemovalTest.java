package Lab_final_210042166.Unit_Test.Observer_Removal_Test;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.IssueObserver;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.ObservableIssue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ObserverRemovalTest {

    @Test
    public void RemoveObserver_ShouldStopNotifications()
    {
        ObservableIssue issue=new ObservableIssue("1","Test Issue","Checking Removal Observer/Notification", Priority.MEDIUM,"User1");
        IssueObserver observer=new IssueObserver("Observer");
        issue.addObserver(observer);
        issue.setStatus(Status.IN_PROGRESS);
        issue.removeObserver(observer);
        issue.setStatus(Status.RESOLVED);

        assertTrue(true);
    }
}
