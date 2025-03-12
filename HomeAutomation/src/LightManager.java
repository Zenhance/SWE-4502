public class LightManager implements IObserver {
    private HomeState homeState;
    private String room;
    private boolean lightsOn;

    public LightManager(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.lightsOn = false;
        homeState.registerObserver(this);
    }


    public void setLightLevel(int lightLevel) {
        homeState.setState("light-" + room, lightLevel);
    }



    public boolean isLightsOn() {
        return lightsOn;
    }

}