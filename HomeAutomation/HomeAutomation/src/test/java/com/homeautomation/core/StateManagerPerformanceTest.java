package com.homeautomation.core;

import com.homeautomation.components.LightManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

public class StateManagerPerformanceTest {
    private StateManager stateManager;

    @BeforeEach
    public void setUp() {
        stateManager = new StateManager();
    }

    @Test
    public void testPerformanceWithManyObservers() {
        // Register 1000 light managers
        IntStream.range(0, 1000).forEach(i -> stateManager.registerComponent(new LightManager()));

        EnvironmentalState state = new EnvironmentalState();
        state.setLightLevel(60);

        long startTime = System.currentTimeMillis();
        stateManager.updateState(state);
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        assertTrue(duration < 500, "State update took too long!"); // Ensure update happens in <500ms
    }
}
