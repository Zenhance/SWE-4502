public class LightManager implements Observer {
    public void update(EnvironmentState state) {
        Integer ambientLight = (Integer) state.getState("lightLevel");
        Boolean occupancy = (Boolean) state.getState("occupancy");

        if (occupancy != null && ambientLight != null) {
            if (occupancy && ambientLight < 30) {
                System.out.println("Turning on lights...");
            } else {
                System.out.println("Turning off lights...");
            }
        }
    }
}

