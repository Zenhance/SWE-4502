public class SmartHomeSystem extends Subject {
    private String systemState;

    // Thi method is to change the state of the system and notify observers
    public void changeState(String newState) {
        this.systemState = newState;
        notifyObservers("System state changed to: " + newState);
    }

    public String getSystemState() {
        return systemState;
    }
}
