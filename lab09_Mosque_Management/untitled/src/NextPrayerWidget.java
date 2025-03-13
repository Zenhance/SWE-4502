import java.util.Map;
import java.time.LocalTime;

class NextPrayerWidget extends Component {
    private String nextPrayer;

    public void updateNextPrayer(LocalTime currentTime, Map<String, LocalTime> prayerTimes) {
        // Logic to determine the next prayer time
        for (Map.Entry<String, LocalTime> entry : prayerTimes.entrySet()) {
            if (currentTime.isBefore(entry.getValue())) {
                nextPrayer = entry.getKey();
                break;
            }
        }
        mediator.notify(this, "prayerDisplayed");
    }

    public String getNextPrayer() {
        return nextPrayer;
    }

    @Override
    public void update() {
        System.out.println("Next Prayer updated: " + nextPrayer);
    }
}
