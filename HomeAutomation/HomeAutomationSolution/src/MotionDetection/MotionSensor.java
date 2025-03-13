package MotionDetection;

import CoreFramework.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// MotionSensor acts as an Observer and tracks motion events
public class MotionSensor implements Observer {
    private List<MotionEvent> motionHistory = new ArrayList<>();

    @Override
    public void update(EnvironmentState state) {
        if (state.isMotionDetected()) {
            MotionEvent event = new MotionEvent(LocalDateTime.now());
            motionHistory.add(event);
            System.out.println("Motion detected! Event logged at " + event.getTimestamp());
        }
    }

    public List<MotionEvent> getMotionHistory() {
        return motionHistory;
    }
}

