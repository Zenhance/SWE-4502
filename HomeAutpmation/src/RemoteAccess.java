public class RemoteAccess implements IObserver {

    private String lastAction;
    private String currentState;

    @Override
    public void update(SystemState state) {

    }

    private void displayCurrentState(String state) {
        currentState = "Current home state: " + state;
        lastAction = currentState;
    }
    private void generateNotification(String message) {
        lastAction = "Notification: " + message;
    }

    public String getLastAction() {
        return lastAction;
    }


}
