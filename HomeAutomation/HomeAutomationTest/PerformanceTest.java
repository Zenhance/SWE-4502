import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
    public SystemStateManager sysState;
    public SystemState state;
    public List<IObserver> observersList;

    @BeforeEach
    public void setup() {
        sysState = new SystemStateManager();
        state = new SystemState();
        observersList = new ArrayList<>();
    }

    @Test
    public void testPerformanceWithManyObservers() {
        int observerCount = 5;
        IObserver observer;

        for (int i = 0; i < observerCount; i++) {
            switch (i) {
                case 0:
                    observer = new MotionDetector();
                    state.motionDetected = true;
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
                default:
                    return;
            }

            observersList.add(observer);
            sysState.registerObserver(observer);
        }

        sysState.setState(state);


        assertTrue(state.motionDetected);
        assertEquals(75, state.lightLevel);
        assertEquals(24, state.temperature);
        assertEquals(900.5, state.energyUsage);
        assertFalse(state.setLightsOn);


        RemoteAccessApp remoteAccessApp = new RemoteAccessApp(sysState);
        System.out.println(remoteAccessApp.displayCurrentState());
    }
}
