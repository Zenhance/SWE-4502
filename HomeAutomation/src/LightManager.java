public class LightManager implements IObserver {
    private HomeState homeState;
    private String room;
    private boolean lightsOn;
    private boolean isOccupied;

    public LightManager(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.lightsOn = false;
        this.isOccupied = false;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("light-" + room) && value instanceof Integer) {
            int lightLevel = (Integer) value;
            updateLights(lightLevel);
        }
        if (stateName.equals("occupied-" + room) && value instanceof Boolean) {
            isOccupied = (Boolean) value;
            Object lightLevel = homeState.getState("light-" + room);
            if (lightLevel != null) {
                updateLights((Integer) lightLevel);
            }
        }
    }

    public void setLightLevel(int lightLevel) {
        homeState.setState("light-" + room, lightLevel);
    }

    public void setOccupancy(boolean occupied) {
        homeState.setState("occupied-" + room, occupied);
    }

    public void setScene(String scene) {
        if (scene.equals("reading") || scene.equals("movie")) {
            lightsOn = true;
        }
        updateLightsState();
    }

    private void updateLights(int lightLevel) {
        // tomarr mathaaa amar mathhaaaaaa dhuurr
        if (isOccupied && lightLevel < 50) {
            lightsOn = true;
        } else {
            lightsOn = false;
        }
        updateLightsState();
    }

    private void updateLightsState() {
        homeState.setState("lights-" + room, lightsOn);
    }

    public boolean isLightsOn() {
        Object status = homeState.getState("lights-" + room);
        return status != null && (Boolean) status;
    }
}