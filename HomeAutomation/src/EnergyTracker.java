public class EnergyTracker implements IObserver {
    private HomeState homeState;
    private int totalUsage;


    public EnergyTracker(HomeState homeState) {
        this.homeState = homeState;
        this.totalUsage = 0;

    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("power-usage") && value instanceof Integer) {
            int usage = (Integer) value;
            totalUsage += usage;

        }
    }


    public void setPowerUsage(int usage) {
        homeState.setState("power-usage", usage);
    }

    public int getTotalUsage() {
        return totalUsage;
    }


}