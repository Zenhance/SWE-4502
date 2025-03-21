package lab11_210042164.test;

import lab11_210042164.implementation.features.VoiceCommandSystem;
import lab11_210042164.implementation.manager.StateManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VoiceCommandSystemTest {

    private TestStateManager testStateManager;
    private VoiceCommandSystem voiceCommandSystem;

    // Custom test implementation of StateManager to track calls
    private static class TestStateManager extends StateManager {
        private Map<String, Object> updatedStates = new HashMap<>();

        @Override
        public void updateState(String key, Object value) {
            super.updateState(key, value);
            updatedStates.put(key, value);
        }

        public boolean wasStateUpdated(String key) {
            return updatedStates.containsKey(key);
        }

        public Object getUpdatedValue(String key) {
            return updatedStates.get(key);
        }

        public void clearUpdatedStates() {
            updatedStates.clear();
        }
    }

    @Before
    public void setUp() {
        testStateManager = new TestStateManager();
        voiceCommandSystem = new VoiceCommandSystem(testStateManager);
    }

    @Test
    public void testProcessLightCommand() {
        // Process a light command
        voiceCommandSystem.processCommand("turn on living room lights");

        // Verify state manager was updated
        assertTrue(testStateManager.wasStateUpdated("lightLevel_LivingRoom"));
        assertEquals(100, testStateManager.getUpdatedValue("lightLevel_LivingRoom"));

        // Check command history
        List<String> history = voiceCommandSystem.getCommandHistory();
        assertEquals(1, history.size());
        assertEquals("turn on living room lights", history.get(0));
    }

    @Test
    public void testProcessTemperatureCommand() {
        // Process a temperature command
        voiceCommandSystem.processCommand("set temperature to 24 degrees");

        // Verify state manager was updated
        assertTrue(testStateManager.wasStateUpdated("targetTemperature"));
        assertEquals(24.0, testStateManager.getUpdatedValue("targetTemperature"));
    }

    @Test
    public void testProcessSceneCommand() {
        // Process a scene command
        voiceCommandSystem.processCommand("activate movie scene");

        // Verify state manager was updated
        assertTrue(testStateManager.wasStateUpdated("lightScene"));
        assertEquals("movie", testStateManager.getUpdatedValue("lightScene"));
    }

    @Test
    public void testUnrecognizedCommand() {
        // Process an unrecognized command
        voiceCommandSystem.processCommand("do something impossible");

        // Verify no state updates
        assertEquals(0, testStateManager.updatedStates.size());

        // Command should still be in history
        List<String> history = voiceCommandSystem.getCommandHistory();
        assertEquals(1, history.size());
        assertEquals("do something impossible", history.get(0));
    }

    @Test
    public void testMultipleCommands() {
        // Process multiple commands
        voiceCommandSystem.processCommand("turn on kitchen lights");
        voiceCommandSystem.processCommand("set temperature to 22 degrees");

        // Verify history contains both commands
        List<String> history = voiceCommandSystem.getCommandHistory();
        assertEquals(2, history.size());
        assertEquals("turn on kitchen lights", history.get(0));
        assertEquals("set temperature to 22 degrees", history.get(1));
    }
}