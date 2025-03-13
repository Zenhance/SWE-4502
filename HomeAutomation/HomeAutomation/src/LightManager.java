public class LightManager implements Observer {
    private boolean lightsOn = false;
    public void update(EnvironmentState state) {
        Integer ambientLight = (Integer) state.getState("lightLevel");
        Boolean occupancy = (Boolean) state.getState("occupancy");

        if (occupancy != null && ambientLight != null) {
            if (occupancy && ambientLight < 30) {
                lightsOn = true;
                System.out.println("Turning on lights...");
            } else {
                lightsOn = false;
                System.out.println("Turning off lights...");
            }
        }
    }
    public boolean areLightsOn() {
        return lightsOn;
    }
}

