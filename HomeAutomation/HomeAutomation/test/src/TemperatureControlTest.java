import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureControlTest {
    @Test
    void testACOn(){
        TemperatureControl temperatureControl=new TemperatureControl();
        EnvironmentState state=new EnvironmentState();

        state.updateState("temperature",26.0);

        temperatureControl.update(state);
        assertTrue(temperatureControl.isAcOn(), "AC should be on when temperature is above 25");
        assertFalse(temperatureControl.isHeaterOn(), "Heater should be off when temperature is above 25");
    }
    @Test
    void testHeaterOn(){
        TemperatureControl temperatureControl=new TemperatureControl();
        EnvironmentState state=new EnvironmentState();

        state.updateState("temperature",13.0);

        temperatureControl.update(state);

        assertTrue(temperatureControl.isHeaterOn(), "Heater should be on when temperature is below 18");
        assertFalse(temperatureControl.isAcOn(), "AC should be off when temperature is below 18");
    }
}
