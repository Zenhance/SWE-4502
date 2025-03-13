public class HomeState extends Subject {
    public String systemState;

    // Represent the system state (motion, room occupancy, light, temperature, energy)
    public boolean motionDetected;
    public boolean roomOccupied;
    public int lightLevel;
    public boolean setLightsOn;
    public int temperature;
    public double energyUsage;

    // Method to change state
    public void setSystemState(String newState) {
        this.systemState = newState;
        notifyObservers(newState);  // Notify observers about the system change
    }

    // Return the current state of the system
    public String getSystemState() {
        return systemState;
    }
}
