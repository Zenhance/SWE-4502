public class RemoteAccess implements IObserver {

    private String lastAction;
    private String currentState;

    @Override
    public void update(SystemState state) {
        String description = state.getStateDescription();

        if (description.equals("System Alert")) {
            generateNotification("Important event occurred in the system.");
        } else {
            displayCurrentState(description);
        }
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
