package Components;

import Core.Observer;

public class RemoteApp implements Observer {
    private boolean notificationReceived = false;

    @Override
    public void update(String state, Object value) {
        notificationReceived = true;
        System.out.println("RemoteApp: Notification - " + state + " changed to " + value);
    }

    public boolean receivedNotification() {
        boolean wasReceived = notificationReceived;
        notificationReceived = false; // Reset after reading to prevent false positives
        return wasReceived;
    }
}
