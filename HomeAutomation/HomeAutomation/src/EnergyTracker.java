public class EnergyTracker implements Observer {
    @Override
    public void update(EnvironmentState state) {
        Integer powerUsage = (Integer) state.getState("powerUsage");
        if (powerUsage != null && powerUsage > 1000) {
            System.out.println("High power consumption detected!");
        }
    }
}
