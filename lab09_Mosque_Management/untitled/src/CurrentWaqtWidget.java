import java.util.Map;
import java.time.LocalTime;

class CurrentWaqtWidget extends Component {
    private String currentWaqt;

    public void updateWaqt(LocalTime currentTime, Map<String, LocalTime> waqtTimes) {
        // Logic to determine current Waqt based on current time and waqt times
        for (Map.Entry<String, LocalTime> entry : waqtTimes.entrySet()) {
            if (currentTime.isBefore(entry.getValue())) {
                currentWaqt = entry.getKey();
                break;
            }
        }
        mediator.notify(this, "waqtDisplayed");
    }

    public String getCurrentWaqt() {
        return currentWaqt;
    }

    @Override
    public void update() {
        System.out.println("Current Waqt updated: " + currentWaqt);
    }
}
