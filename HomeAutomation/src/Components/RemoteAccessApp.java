package Components;

import Core_Models.IObserver;
import Core_Models.SystemState;
import Core_Models.SystemStateManager;

public class RemoteAccessApp implements IObserver {
    private SystemState state;
    private SystemStateManager sysState;

    public RemoteAccessApp(SystemStateManager systemStateManager)
    {
        this.sysState = systemStateManager;
        sysState.registerObserver(this);
        this.state = sysState.state;
    }

    public void update(SystemState state) {
        this.state = state;
    }

    public String displayCurrentState() {
        return "Home System Status:\n"
                + "Motion Detected: " + (state.motionDetected ? "Yes" : "No") + "\n"
                + "Room Occupied: " + (state.roomOccupied ? "Yes" : "No") + "\n"
                + "Light Level: " + state.lightLevel + "\n"
                + "Lights On: " + (state.setLightsOn ? "Yes" : "No") + "\n"
                + "Temperature: " + state.temperature + "°C\n"
                + "Energy Usage: " + state.energyUsage + " watts";
    }

    public String generateNotification(String message) {
        return "NOTIFICATION: " + message;
    }

    public String remoteControl(String command) {
        if (command.toLowerCase().contains("turn on the lights"))
        {
            state.setLightsOn = true;
            sysState.setState(state);
            return generateNotification("Lights turned ON remotely.");
        }
        else if (command.toLowerCase().contains("turn off the lights"))
        {
            state.setLightsOn = false;
            sysState.setState(state);
            return generateNotification("Lights turned OFF remotely.");
        }
        else{
            return "ERROR: Unrecognized command!";
        }

    }
}
