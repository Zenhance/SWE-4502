import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MotionDetectorTest {

    private MotionDetector motionDetector;
    private SystemState State;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        motionDetector = new MotionDetector();
        State = new SystemState(SystemStateType.Living_Room, "Living Room");


        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testNormalMotionActivity() {

        motionDetector.update(State);
        assertEquals(1, motionDetector.getMotionCount("Living Room"));
        String output = outContent.toString();
        assertTrue(output.contains("Logging motion: Living Room"));
        assertTrue(output.contains("Normal motion activity detected"));
    }

    @Test
    public void testSuspiciousActivity() {

        for (int i = 0; i < 6; i++) {
            motionDetector.update(State);
        }
        assertEquals(6, motionDetector.getMotionCount("Living Room"));
        String output = outContent.toString();
        assertTrue(output.contains("Suspicious activity detected"));
    }

    @Test
    public void testMotionLoggingOutput() {
        outContent.reset();
        motionDetector.update(State);
        String output = outContent.toString();
        assertTrue(output.contains("Logging motion: Living Room"));
        assertTrue(output.contains("Normal motion activity detected"));
    }

}
