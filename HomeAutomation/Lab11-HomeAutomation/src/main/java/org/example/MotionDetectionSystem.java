package org.example;

//import smarthome.core;
import java.time.LocalDateTime;
import java.util.*;

public class MotionDetectionSystem implements StateChangeObserver {
    private HomeSystem homeSystem;
    private List<MotionEvent> motionEvents = new ArrayList<>();

    public MotionDetectionSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
        homeSystem.registerObserver("motion", this);
    }

    @Override
    public void onStateChange(String property, Object oldValue, Object newValue) {
        if (property.equals("motion") && newValue instanceof Boolean && (Boolean)newValue) {
            String location = (String)homeSystem.getStateValue("currentRoom");
            recordMotion(location);
        }
    }

    public void recordMotion(String location) {
        MotionEvent event = new MotionEvent(location, LocalDateTime.now());
        motionEvents.add(event);
        System.out.println("Motion detected in " + location + " at " + event.getTime());

        // Simple analysis of suspicious behavior (just for demo)
        if (isNightTime() && location.equals("entrance")) {
            System.out.println("ALERT: Possible suspicious activity at entrance during night hours");
        }
    }

    private boolean isNightTime() {
        int hour = LocalDateTime.now().getHour();
        return hour >= 22 || hour <= 5;
    }

    // Inner class to store motion events
    private static class MotionEvent {
        private String location;
        private LocalDateTime time;

        public MotionEvent(String location, LocalDateTime time) {
            this.location = location;
            this.time = time;
        }

        public String getLocation() { return location; }
        public LocalDateTime getTime() { return time; }
    }
}