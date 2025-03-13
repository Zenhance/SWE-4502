package com.homeautomation.core;

import com.homeautomation.components.LightManager;
import com.homeautomation.components.TemperatureControl;
import com.homeautomation.components.MotionDetector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StateManagerIntegrationTest {
    private StateManager stateManager;
    private LightManager lightManager;
    private TemperatureControl temperatureControl;
    private MotionDetector motionDetector;

    @BeforeEach
    public void setUp() {
        stateManager = new StateManager();
        lightManager = new LightManager();
        temperatureControl = new TemperatureControl(22.5);
        motionDetector = new MotionDetector();

        stateManager.registerComponent(lightManager);
        stateManager.registerComponent(temperatureControl);
        stateManager.registerComponent(motionDetector);
    }

    @Test
    public void testComponentsReceiveUpdates() {
        // Set environmental state
        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(80);
        state.setTemperature(25);
        state.setRoomOccupied(true);
        state.setMotionDetected(true);  // ✅ Explicitly set motion detected
        state.setMotionLocation("Living Room");  // ✅ Set location

        System.out.println("Before update: Motion detected? " + motionDetector.isMotionDetected());

        // Update state
        stateManager.updateState(state);

        System.out.println("After update: Motion detected? " + motionDetector.isMotionDetected());
        System.out.println("Motion detected in: " + motionDetector.getLastDetectedLocation());

        // Assertions
        assertEquals(80, lightManager.getCurrentLightLevel(), "Light level mismatch");
        assertEquals(25, temperatureControl.getCurrentTemperature(), "Temperature mismatch");
        assertTrue(motionDetector.isMotionDetected(), "Motion detection failed");
        assertEquals("Living Room", motionDetector.getLastDetectedLocation(), "Motion location mismatch");
    }
}
