public class EnergyTracker implements IObserver {
    private HomeState homeState;
    private int totalUsage;
    private boolean isUnusual;

    public EnergyTracker(HomeState homeState) {
        this.homeState = homeState;
        this.totalUsage = 0;
        this.isUnusual = false;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("power-usage") && value instanceof Integer) {
            int usage = (Integer) value;
            totalUsage += usage;
            checkUnusual(usage);
        }
    }

    public void setPowerUsage(int usage) {
        homeState.setState("power-usage", usage);
    }

    private void checkUnusual(int usage) {
        if (usage > 1000) { // set korlam arki ekta nije nijee valuee
            isUnusual = true;
        } else {
            isUnusual = false;
        }
        homeState.setState("unusual-usage", isUnusual);
    }

    public int getTotalUsage() {
        return totalUsage;
    }

    public boolean isUnusual() {
        Object status = homeState.getState("unusual-usage");
        return status != null && (Boolean) status;
    }
}