public class EnergyTracker implements Observer {
    private int powerUsage;

    @Override
    public void update(EnvironmentalState state) {

        this.powerUsage = state.getPowerUsage();
        monitorEnergyUsage();
    }

    private void monitorEnergyUsage() {
        if (powerUsage > 500) {
            System.out.println("Warning: High power consumption detected!");
        } else if (powerUsage > 100 && powerUsage <= 500) {
            System.out.println("Normal power consumption detected!");
        } else{
            System.out.println("Warning: Low power consumption detected!");
        }
    }

    public int getPowerUsage() {
        return powerUsage;
    }
}
