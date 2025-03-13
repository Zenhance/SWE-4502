package UnitTest;
import CoreFramework.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EnvironmentMonitorTest {
    @Test
    public void testObserverNotification() {
        // Capture System.out to verify logging
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            EnvironmentMonitor monitor = new EnvironmentMonitor();
            LoggingComponent logger = new LoggingComponent("Logger1");

            monitor.registerObserver(logger);

            EnvironmentState newState = new EnvironmentState(true, 22, 75);
            monitor.setState(newState);

            // Verify logging output contains expected information
            String logOutput = outContent.toString();
            assertTrue(logOutput.contains("Logger1 received update:"), 
                "Logger should log an update message");
            assertTrue(logOutput.contains("CoreFramework.EnvironmentState{motionDetected=true, temperature=22, lightLevel=75}"), 
                "Logger should log the specific environment state");
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}
