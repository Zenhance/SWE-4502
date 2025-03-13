import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class VoiceCommandProcessorTest {
    private EnvironmentMonitor monitor;
    private VoiceCommandProcessor processor;

    @Before
    public void setUp() {
        monitor = new EnvironmentMonitor();
        processor = new VoiceCommandProcessor(monitor);
    }

    // ✅ Test 1: Process "turn on lights" command
    @Test
    public void testTurnOnLightsCommand() {
        processor.processCommand("turn on lights");

        assertEquals(70, monitor.state.lightLevel, 0.01);
        assertTrue(processor.getCommandHistory().contains("turn on lights"));
    }

    // ✅ Test 2: Process "turn off lights" command
    @Test
    public void testTurnOffLightsCommand() {
        processor.processCommand("turn off lights");

        assertEquals(0, monitor.state.lightLevel, 0.01);
        assertTrue(processor.getCommandHistory().contains("turn off lights"));
    }

    // ✅ Test 3: Process "set temperature to 25" command
    @Test
    public void testSetTemperatureCommand() {
        processor.processCommand("set temperature to 25");

        assertEquals(25.0, monitor.state.temperature, 0.01);
        assertTrue(processor.getCommandHistory().contains("set temperature to 25"));
    }



    // ✅ Test 4: Maintain correct command history
    @Test
    public void testCommandHistory() {
        processor.processCommand("turn on lights");
        processor.processCommand("set temperature to 22");
        processor.processCommand("turn off lights");

        List<String> history = processor.getCommandHistory();

        assertEquals(3, history.size());
        assertEquals("turn on lights", history.get(0));
        assertEquals("set temperature to 22", history.get(1));
        assertEquals("turn off lights", history.get(2));
    }
}
