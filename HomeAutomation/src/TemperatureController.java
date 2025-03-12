public class TemperatureController implements IObserver {
    private HomeState homeState;
    private String room;
    private boolean heatingOn;
    private boolean coolingOn;

    public TemperatureController(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.heatingOn = false;
        this.coolingOn = false;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("temp-" + room) && value instanceof Integer) {
            int temp = (Integer) value;
            int target = 20; // just faltu ami ekta bhaiii !!!!!!!!!!!!

            if (temp < target - 1) {
                heatingOn = true;
                coolingOn = false;
            } else if (temp > target + 1) {
                heatingOn = false;
                coolingOn = true;
            } else {
                heatingOn = false;
                coolingOn = false;
            }
            homeState.setState("heating-" + room, heatingOn);
            homeState.setState("cooling-" + room, coolingOn);
        }
    }

    public void setTemperature(int temp) {
        homeState.setState("temp-" + room, temp);
    }

    public boolean isHeatingOn() {
        Object status = homeState.getState("heating-" + room);
        return status != null && (Boolean) status;
    }

    public boolean isCoolingOn() {
        Object status = homeState.getState("cooling-" + room);
        return status != null && (Boolean) status;
    }
}

