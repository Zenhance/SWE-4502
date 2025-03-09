public class RemoteAccessApp implements IObserver {
    private SystemState state;

    public RemoteAccessApp(SystemStateManager systemStateManager)
    {
        systemStateManager.registerObserver(this);
        this.state = systemStateManager.state;
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
}
