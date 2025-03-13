public class EnergyTracker implements Observer {
    private boolean highPowerUsageDetected=false;
    public void update(EnvironmentState state) {
        Integer powerUsage = (Integer) state.getState("powerUsage");
        if (powerUsage != null && powerUsage > 1000) {
            highPowerUsageDetected=true;
            System.out.println("High power consumption detected!");
        }
    }
    public boolean isPowerHigh(){
        return highPowerUsageDetected;
    }
}
