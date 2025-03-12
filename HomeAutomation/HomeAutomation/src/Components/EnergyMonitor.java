package Components;
import Core.Observer;
import Core.SmartHomeData;

public class EnergyMonitor implements Observer {
    private final SmartHomeData homeData;

    public EnergyMonitor(SmartHomeData homeData) {
        this.homeData = homeData;
    }

    @Override
    public void update(String state, Object value) {
        if ("POWER_USAGE".equals(state)) {
            double usage = (Double) value;
            homeData.addReading("POWER_USAGE", usage);
            System.out.println("EnergyMonitor: Current power usage is " + usage + " kWh");
        }
    }
}
