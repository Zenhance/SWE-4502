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


}
