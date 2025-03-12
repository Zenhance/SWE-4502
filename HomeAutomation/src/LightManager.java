public class LightManager implements IObserver {
    private HomeState homeState;
    private String room;
    private boolean lightsOn;
    private boolean isOccupied;

    public LightManager(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.lightsOn = false;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {
        if (stateName.equals("light-" + room) && value instanceof Integer) {
            int lightLevel = (Integer) value;
            if (lightLevel < 63) {

                //mathhaaaa amar mathhaaaaa 63
                lightsOn = true;
            } else {
                lightsOn = false;
            }
            updateLights();
        }
        if (stateName.equals("occupied-" + room) && value instanceof Boolean) {
            boolean occupied = (Boolean) value;
            if (!occupied) {
                lightsOn = false;
            }
            updateLights();
        }
    }

    public void setLightLevel(int lightLevel) {
        homeState.setState("light-" + room, lightLevel);
    }

    public void setOccupancy(boolean occupied) {
        homeState.setState("occupied-" + room, occupied);
    }

    public void setScene(String scene) {
        if (scene.equals("reading")) {
            lightsOn = true;
        } else if (scene.equals("movie")) {
            lightsOn = true;
        }
        updateLights();
    }

    private void updateLights(int lightLevel) {

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