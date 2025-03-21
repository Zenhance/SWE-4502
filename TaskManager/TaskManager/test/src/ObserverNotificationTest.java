import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverNotificationTest{
    @Test
    void testObserverNotification(){
        Observer user=new User();
        Subject informer=new Informer();
        informer.notifyUsers("Bad","user@gmail.com");
        assertEquals("True",informer.getDone());
    }
}