import java.util.ArrayList;
import java.util.List;

public class RemoteAccessApp implements IObserver {
    private HomeState homeState;
    private String room;
    private List<String> notifications;

    public RemoteAccessApp(HomeState homeState, String room) {
        this.homeState = homeState;
        this.room = room;
        this.notifications = new ArrayList<>();
        homeState.registerObserver(this);
    }

    @Override
    public void update(String stateName, Object value) {

        if (stateName.equals("suspicious-" + room) && value instanceof Boolean) {
            if ((Boolean) value) {
                notifications.add("Suspicious motion detected in " + room);
            }
        }

        if (stateName.equals("unusual-usage") && value instanceof Boolean) {
            if ((Boolean) value) {
                notifications.add("High energy usage detected");
            }
        }
    }

    public void controlLights(String command) {

        homeState.setState("voice-" + room, command);
    }

    public boolean getLightsState() {
        Object status = homeState.getState("lights-" + room);
        return status != null && (Boolean) status;
    }

    public int getTemperature() {
        Object temp = homeState.getState("temp-" + room);
        return temp != null ? (Integer) temp : 0;
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }
}