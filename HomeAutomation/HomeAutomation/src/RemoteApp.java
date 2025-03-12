public class RemoteApp implements Observer {
    @Override
    public void update(String state, Object value) {
        System.out.println("RemoteApp: Received update - " + state + " changed to " + value);
    }

    public void sendNotification(String message) {
        System.out.println("RemoteApp: NOTIFICATION - " + message);
    }
}
