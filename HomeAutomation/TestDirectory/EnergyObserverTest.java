import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnergyObserverTest {

    // Test Case 1: Track Energy Consumption Updates
    @Test
    void testEnergyConsumptionUpdate() {
        // Create energy control system and observer
        EnergyControlSystem energySystem = new EnergyControlSystem();
        EnergyObserver observer = new EnergyObserver();

        // Register observer
        energySystem.registerObserver(observer);

        // Simulate power usage changes
        energySystem.changeEnergyUsage(100, "Living Room");
        energySystem.changeEnergyUsage(150, "Bedroom");
        energySystem.changeEnergyUsage(200, "Kitchen");

        // Assert that the observer received the correct energy usage data
        assertEquals(200, observer.currentPowerUsage);
        assertEquals("Kitchen", observer.lastRoom);
        assertEquals(150, observer.averageUsage, 0.01); // Test average usage
    }

    // Test Case 2: Track Low Power Consumption
    @Test
    void testLowEnergyConsumption() {
        // Create energy control system and observer
        EnergyControlSystem energySystem = new EnergyControlSystem();
        EnergyObserver observer = new EnergyObserver();

        // Register observer
        energySystem.registerObserver(observer);

        // Simulate low power usage
        energySystem.changeEnergyUsage(50, "Living Room");

        // Assert that the observer received the correct energy usage data
        assertEquals(50, observer.currentPowerUsage);
        assertEquals("Living Room", observer.lastRoom);
    }

}
