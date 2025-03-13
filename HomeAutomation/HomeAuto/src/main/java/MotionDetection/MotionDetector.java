package MotionDetection;

import Core.Observer;

import java.time.LocalDateTime;
import java.util.List;

public class MotionDetector implements Observer{

    private boolean motionDetected;
    private List<MotionLogEntry> motionLogs;
    private int suspiciousThreshold= 5;

    public void update(String eventType, Object value){

        if(eventType.equals("motionEvent")){
            this.motionDetected= (boolean) value;
            if(motionDetected){
                logMotion("Living Room");
            }
        }

    }

    private void logMotion(String location){
        MotionLogEntry logEntry = new MotionLogEntry(LocalDateTime.now(), location);
        motionLogs.add(logEntry);
    }


    public boolean isSuspicious() {
        // Check if there are more than suspiciousThreshold motion events within a short time window (e.g., last 5 minutes)
        LocalDateTime now = LocalDateTime.now();
        int count = 0;

        for (MotionLogEntry entry : motionLogs) {
            if (entry.getTimestamp().isAfter(now.minusMinutes(5))) { // 5-minute window
                count++;
            }
        }

        return count >= suspiciousThreshold; // If more than the threshold, it's suspicious
    }

    // Getter for motion detected state
    public boolean isMotionDetected() {
        return motionDetected;
    }

    // Getter for motion logs
    public List<MotionLogEntry> getMotionLogs() {
        return motionLogs;
    }

    public class MotionLogEntry {
        private LocalDateTime timestamp;
        private String location;

        public MotionLogEntry(LocalDateTime timestamp, String location) {
            this.timestamp = timestamp;
            this.location = location;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getLocation() {
            return location;
        }
    }
}
