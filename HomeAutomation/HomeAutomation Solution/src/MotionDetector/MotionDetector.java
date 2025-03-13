package MotionDetector;

import CoreFramework.HomeEnvironment;
import CoreFramework.Observer;

import java.util.ArrayList;
import java.util.List;

public class MotionDetector implements Observer {
    private List<MotionEvent> motionEvents = new ArrayList<>();

    public MotionDetector() {
        HomeEnvironment.getInstance().registerObserver("motion", this);
    }

    @Override
    public void update(String eventType, Object value) {
        if (eventType.equals("motion") && value instanceof Boolean && (Boolean) value) {
            detectMotion();
        }
    }

    public void detectMotion() {
        MotionEvent event = new MotionEvent(System.currentTimeMillis(), "Living Room");
        motionEvents.add(event);
        System.out.println("Motion detected: " + event);
        analyzePattern();
    }

    public void analyzePattern() {
        // Simple analysis logic
        if (motionEvents.size() > 3) {
            System.out.println("Motion pattern analysis: Normal activity");
        }
    }

    public List<MotionEvent> getMotionEvents() {
        return new ArrayList<>(motionEvents);
    }
}
