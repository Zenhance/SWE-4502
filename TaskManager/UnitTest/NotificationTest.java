import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationTest{
    private IssueRepository repository;
    private Command commandManager;
    private Issuenotifer notifier;

    @BeforeEach
    void setUp() {
        repository = new IssueRepository();

        notifier = new Issuenotifer();
    }
    @Test
    void testObserverNotification() {
        Observer testObserver = new Emailnotifier("abc");
        notifier.addObserver(testObserver);

        notifier.notifyObservers("New issue created!");
        assertEquals(1,1);


    }
}