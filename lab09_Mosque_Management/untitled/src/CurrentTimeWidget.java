import java.util.Map;
import java.time.LocalTime;

class CurrentTimeWidget extends Component {
    private LocalTime currentTime;

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        mediator.notify(this, "timeUpdated");
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    @Override
    public void update() {
        System.out.println("Current Time Widget updated: " + currentTime);
    }
}
