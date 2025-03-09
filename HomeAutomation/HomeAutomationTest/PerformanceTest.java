import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerformanceTest {
    public SystemStateManager sysState;
    public SystemState state;
    public IObserver observer;

    @BeforeEach
    public void setup() {
        sysState = new SystemStateManager();
        state = new SystemState();

    }

    @Test
    public void testPerformanceWithManyObservers() {
        int observerCount = 5;


        for (int i = 0; i < observerCount; i++) {

            switch (i) {
                case 0:
                    observer = new MotionDetector();
                    state.motionDetected =true;
                    break;
                case 1:
                    observer = new LightManager();
                    state.lightLevel = 75;
                    break;
                case 2:
                    observer = new TemperatureController();
                    state.temperature = 24;
                    break;
                case 3:
                    observer = new EnergyTracker();
                    state.energyUsage = 900.5;
                    break;
                case 4:
                    observer = new VoiceCommandFollower();
                    state.voiceCommand = "Turn off the lights";
                    break;

            }
            sysState.registerObserver(observer);
            sysState.setState(state);
        }

        assertTrue(state.motionDetected);
        assertEquals(75, state.lightLevel);
        assertEquals(24, state.temperature);
        assertEquals(900.5, state.energyUsage);
        assertFalse(state.setLightsOn);
    }
}
