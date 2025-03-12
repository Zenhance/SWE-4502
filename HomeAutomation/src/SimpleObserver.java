public class SimpleObserver implements Observer {
    private String lastMessage;

    // This method is called when the system state changes
    @Override
    public void update(String message) {
        this.lastMessage = message;
        System.out.println("Received message: " + message);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
