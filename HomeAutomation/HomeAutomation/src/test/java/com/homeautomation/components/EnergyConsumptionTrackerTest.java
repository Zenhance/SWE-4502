package com.homeautomation.components;

import com.homeautomation.core.EnvironmentalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnergyConsumptionTrackerTest {
    private EnergyConsumptionTracker tracker;
    private EnvironmentalState state;

    @BeforeEach
    void setUp() {
        tracker = new EnergyConsumptionTracker();
        state = new EnvironmentalState();
    }

    @Test
    void testAddDeviceConsumption() {
        tracker.addDevice("Fridge", 1.5);
        tracker.addDevice("Heater", 2.0);
        assertEquals(2, tracker.getDeviceConsumption().size());
    }

    @Test
    void testRemoveDeviceConsumption() {
        tracker.addDevice("Fridge", 1.5);
        tracker.removeDevice("Fridge");
        assertEquals(0, tracker.getDeviceConsumption().size());
    }

    @Test
    void testEnergyConsumptionTracking() {
        tracker.addDevice("AC", 3.0);
        tracker.addDevice("TV", 0.5);
        tracker.updateState(state);
        assertEquals(3.5, tracker.getTotalEnergyConsumed());
    }
}
