public class RemoteAccessApp implements Observer {
    public EnvironmentalState currentState;

    @Override
    public void update(EnvironmentalState state) {
        this.currentState = state;
        sendNotification();
    }

    private void sendNotification() {
        System.out.println("Notification: Home status updated.");
    }

    public EnvironmentalState getCurrentState() {
        return currentState;
    }
}
