package voice;

import core.StateManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandProcessorTest {

    @Test
    void testProcessCommandTurnsOnLights() {
        StateManager stateManager = new StateManager();
        CommandProcessor commandProcessor = new CommandProcessor(stateManager);
        String command = "turn on lights";

        commandProcessor.processCommand(command);

    }

    @Test
    void testProcessCommandTurnsOffLights() {
        StateManager stateManager = new StateManager();
        CommandProcessor commandProcessor = new CommandProcessor(stateManager);
        String command = "turn off lights";

        commandProcessor.processCommand(command);
    }

    @Test
    void testProcessCommandIncreasesTemperature() {
        StateManager stateManager = new StateManager();
        CommandProcessor commandProcessor = new CommandProcessor(stateManager);
        String command = "increase temperature";

        commandProcessor.processCommand(command);
    }

    @Test
    void testGetLastProcessedCommand() {
        StateManager stateManager = new StateManager();
        CommandProcessor commandProcessor = new CommandProcessor(stateManager);

        String lastCommand = commandProcessor.getLastProcessedCommand();

        assertEquals("Last command", lastCommand, "getLastProcessedCommand() should return the correct value");
    }
}
