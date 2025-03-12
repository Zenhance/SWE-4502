import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    @Test
    void testObserverReceivesMessage() {
        // Lets create subject (SmartHomeSystem) and observer (SimpleObserver)
        SmartHomeSystem system = new SmartHomeSystem();
        SimpleObserver observer = new SimpleObserver();

        // Register observer to the system
        system.registerObserver(observer);

        // Change the system state
        system.changeState("ACTIVE");

        // Assert that observer received the correct message
        assertEquals("System state changed to: ACTIVE", observer.getLastMessage());
    }
}
