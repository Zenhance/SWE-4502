public class VoiceCommandSystem implements IObserver {
    private HomeState homeState;



    public VoiceCommandSystem(HomeState homeState, String room) {
        this.homeState = homeState;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {

        }
    }


