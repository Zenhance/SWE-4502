import java.util.Map;
import java.time.LocalTime;
import java.util.HashMap;

class PrayerTimeTableWidget extends Component {
    private Map<String, LocalTime> prayerTimes = new HashMap<>();

    public void setPrayerTimes(Map<String, LocalTime> prayerTimes) {
        this.prayerTimes = prayerTimes;
        mediator.notify(this, "prayerUpdated");
    }

    public Map<String, LocalTime> getPrayerTimes() {
        return prayerTimes;
    }

    @Override
    public void update() {
        System.out.println("Prayer Time Tables updated: " + prayerTimes);
    }
}