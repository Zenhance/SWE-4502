import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;

class WaqtTimeTablesWidget extends Component {
    private Map<String, LocalTime> waqtTimes = new HashMap<>();

    public void setWaqtTimes(Map<String, LocalTime> waqtTimes) {
        this.waqtTimes = waqtTimes;
        mediator.notify(this, "waqtUpdated");
    }

    public Map<String, LocalTime> getWaqtTimes() {
        return waqtTimes;
    }

    @Override
    public void update() {
        System.out.println("Waqt Time Tables updated: " + waqtTimes);
    }
}
