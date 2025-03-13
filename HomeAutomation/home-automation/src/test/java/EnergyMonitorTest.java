import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import observers.EnergyMonitor;
import subjects.HomeAutomationSystem;
import models.EnvironmentState;

public class EnergyMonitorTest {
    // Mock Instances
    @Mock
    private EnergyMonitor mockEnergyMonitor;

    // Actual Instances
    private EnergyMonitor energyMonitor;
    private HomeAutomationSystem homeAutomationSystem;

    @BeforeEach
    void setUp() {
        homeAutomationSystem = new HomeAutomationSystem();
        mockEnergyMonitor = mock(EnergyMonitor.class);
        energyMonitor = new EnergyMonitor();

        homeAutomationSystem.registerObserver(mockEnergyMonitor);
        homeAutomationSystem.registerObserver(energyMonitor);
    }

    @Test
    public void testUpdateMethodCalled() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setPowerUsage(120.5);
        homeAutomationSystem.setEnvironmentState(environmentState);

        verify(mockEnergyMonitor).update(any());
    }

    @Test
    public void testEnergyConsumptionTracking() {
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.setPowerUsage(120.5);
        homeAutomationSystem.setEnvironmentState(environmentState);

        assertEquals(120.5, energyMonitor.getTotalEnergyConsumed());
    }
}
