package remote;

import core.StateManager;

public class RemoteAccess {
    private StateManager stateManager;

    public RemoteAccess(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public String getHomeState() {
        // Logic to retrieve and format the current home state
        return "Home state";
    }

    public void sendNotification(String event) {
        // Logic to send a notification
    }

    public void controlSystem(String command) {
        // Logic to control the system remotely
    }
}
