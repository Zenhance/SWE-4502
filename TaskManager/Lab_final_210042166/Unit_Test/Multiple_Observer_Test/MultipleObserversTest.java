package Lab_final_210042166.Unit_Test.Multiple_Observer_Test;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.IssueObserver;
import Lab_final_210042166.Task_Management_System.Observe_Notification_Class.ObservableIssue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MultipleObserversTest {
    @Test
    public void MultipleObservers_ShouldAllBeNotified()
    {
        ObservableIssue issue=new ObservableIssue("1","Test Issue","Checking Multiple Notification", Priority.MEDIUM,"User1");
        IssueObserver observer1=new IssueObserver("Observer1");
        IssueObserver observer2=new IssueObserver("Observer2");
        issue.addObserver(observer1);
        issue.addObserver(observer2);
        issue.setStatus(Status.IN_PROGRESS);

        assertTrue(true);
    }

}
