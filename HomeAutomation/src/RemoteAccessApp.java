public class RemoteAccessApp implements IObserver {
    private HomeState homeState;
    private String room;


    public RemoteAccessApp(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {

        }
    }

