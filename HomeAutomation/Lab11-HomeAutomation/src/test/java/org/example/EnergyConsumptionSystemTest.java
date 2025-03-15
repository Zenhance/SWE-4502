package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyConsumptionSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    private EnergyConsumptionSystem energySystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        energySystem = new EnergyConsumptionSystem(mockHomeSystem);

        // Verify observer registration
        Mockito.verify(mockHomeSystem).registerObserver("devicePower", energySystem);
    }

    @Test
    public void testRecordConsumption() {
        // Create a device status map
        Map<String, Boolean> deviceStatus = new HashMap<>();
        deviceStatus.put("hvac", true);
        deviceStatus.put("lighting", true);
        deviceStatus.put("kitchen", false);

        // Record consumption
        energySystem.recordConsumption(deviceStatus);

        // Check that energy readings were recorded
        try {
            Field readingsField = EnergyConsumptionSystem.class.getDeclaredField("energyReadings");
            readingsField.setAccessible(true);
            List<?> readings = (List<?>) readingsField.get(energySystem);

            // Verify a reading was recorded
            assertEquals(1, readings.size());

            // Verify the total consumption was updated (hvac + lighting = 2500 + 800 = 3300 watts -> 3.3 kwh)
            Field totalConsumptionField = EnergyConsumptionSystem.class.getDeclaredField("totalConsumption");
            totalConsumptionField.setAccessible(true);
            double totalConsumption = (double) totalConsumptionField.get(energySystem);

            assertEquals(3.3, totalConsumption, 0.01);
        } catch (Exception e) {
            fail("Failed to access fields: " + e.getMessage());
        }
    }

    @Test
    public void testOnStateChange() {
        // Create a device status map
        Map<String, Boolean> deviceStatus = new HashMap<>();
        deviceStatus.put("hvac", true);
        deviceStatus.put("lighting", false);

        // Trigger state change through observer interface
        energySystem.onStateChange("devicePower", null, deviceStatus);

        // Check that energy readings were recorded
        try {
            Field readingsField = EnergyConsumptionSystem.class.getDeclaredField("energyReadings");
            readingsField.setAccessible(true);
            List<?> readings = (List<?>) readingsField.get(energySystem);

            // Verify a reading was recorded
            assertEquals(1, readings.size());

            // Verify the total consumption was updated (hvac only = 2500 watts -> 2.5 kwh)
            Field totalConsumptionField = EnergyConsumptionSystem.class.getDeclaredField("totalConsumption");
            totalConsumptionField.setAccessible(true);
            double totalConsumption = (double) totalConsumptionField.get(energySystem);

            assertEquals(2.5, totalConsumption, 0.01);
        } catch (Exception e) {
            fail("Failed to access fields: " + e.getMessage());
        }
    }

    @Test
    public void testIgnoresNonMapDevicePower() {
        // This should not record any consumption
        energySystem.onStateChange("devicePower", null, "active");

        // Check that no energy readings were recorded
        try {
            Field readingsField = EnergyConsumptionSystem.class.getDeclaredField("energyReadings");
            readingsField.setAccessible(true);
            List<?> readings = (List<?>) readingsField.get(energySystem);

            // Verify no readings were recorded
            assertEquals(0, readings.size());
        } catch (Exception e) {
            fail("Failed to access fields: " + e.getMessage());
        }
    }

    @Test
    public void testMultipleDeviceUsage() {
        // First usage
        Map<String, Boolean> deviceStatus1 = new HashMap<>();
        deviceStatus1.put("hvac", true);
        energySystem.recordConsumption(deviceStatus1);

        // Second usage
        Map<String, Boolean> deviceStatus2 = new HashMap<>();
        deviceStatus2.put("lighting", true);
        energySystem.recordConsumption(deviceStatus2);

        // Check that total consumption is cumulative
        try {
            Field totalConsumptionField = EnergyConsumptionSystem.class.getDeclaredField("totalConsumption");
            totalConsumptionField.setAccessible(true);
            double totalConsumption = (double) totalConsumptionField.get(energySystem);

            // hvac = 2.5 kwh, lighting = 0.8 kwh -> total 3.3 kwh
            assertEquals(3.3, totalConsumption, 0.01);
        } catch (Exception e) {
            fail("Failed to access fields: " + e.getMessage());
        }
    }
}