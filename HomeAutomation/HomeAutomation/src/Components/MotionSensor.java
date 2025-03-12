package Components;

import Core.Observer;
import Core.SmartHomeData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotionSensor implements Observer {
    private final SmartHomeData homeData;
    private final List<String> activityLog = new ArrayList<>();

    public MotionSensor(SmartHomeData homeData) {
        this.homeData = homeData;
    }

    @Override
    public void update(String state, Object value) {
        if ("MOTION".equals(state)) {
            boolean motionDetected = (Boolean) value;
            homeData.addReading("MOTION", motionDetected ? 1.0 : 0.0);
            activityLog.add(LocalDateTime.now() + " - Motion detected: " + motionDetected);
            System.out.println("Motion Sensor: Motion " + (motionDetected ? "detected" : "not detected"));
        }
    }

    public List<String> getActivityLog() {
        return new ArrayList<>(activityLog);
    }
}
