import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ObserverTestcase {
    private ObservableIssue issue;
    private User user1;
    private User user2;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        issue = new ObservableIssue(1, "Test Issue", "Testing observer pattern", Priority.MEDIUM, Status.OPEN,"SLICE");
        user1 = new User("Alice");
        user2 = new User("Bob");

        issue.addObserver(user1);
        issue.addObserver(user2);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void ObserverNotification_ShouldNotifyAllUers() {
        issue.changeStatus(Status.RESOLVED);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Alice received notification: Issue status changed to: RESOLVED"));
        assertTrue(output.contains("Bob received notification: Issue status changed to: RESOLVED"));
    }
}
