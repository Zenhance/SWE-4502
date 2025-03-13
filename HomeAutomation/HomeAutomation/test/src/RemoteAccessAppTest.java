import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoteAccessAppTest {
    @Test
    void testRemoteAccessApp(){
        RemoteAccessApp app=new RemoteAccessApp();
        EnvironmentState state=new EnvironmentState();

        state.updateState("motion",true);
        state.updateState("temperature", 15.0);
        state.updateState("lightLevel",50);
        state.updateState("occupancy",true);
        state.updateState("powerUsage",1000);

        app.update(state);
    }
    @Test
    void testRemoteControl(){
        RemoteAccessApp app=new RemoteAccessApp();
        HomeAutomation hub=new HomeAutomation();

        app.remoteControl("lightLevel",20,hub);

        assertEquals(20,hub.getState("lightLevel"));
    }
}
