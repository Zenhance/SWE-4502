package MotionDetector;

import CoreFramework.EnvironmentStateKeys;
import CoreFramework.SmartHomeComponent;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

public class MotionDetector extends SmartHomeComponent {

    private static final Logger LOGGER = Logger.getLogger(MotionDetector.class.getName());

    private Map<String, List<MotionEvent>> locationHistory=new HashMap<>();
    private final int suspiciousThreshold;

    public MotionDetector(String componentId, int suspiciousThreshold) {
        super(componentId);
        this.suspiciousThreshold = suspiciousThreshold;
    }

    @Override
    public void initialize() {
        environmentState.registerObserver(EnvironmentStateKeys.MOTION_DETECTED,this);
        environmentState.registerObserver(EnvironmentStateKeys.MOTION_LOCATION,this);
        LOGGER.info("Motion Detector initialized");
    }

    @Override
    public void shutdown() {
        environmentState.unregisterObserver(EnvironmentStateKeys.MOTION_DETECTED,this);
        environmentState.unregisterObserver(EnvironmentStateKeys.MOTION_LOCATION,this);
        LOGGER.info("Motion Detector shutdown");
    }

    @Override
    public void onEnvironmentChange(String key, Object newValue){
        if (EnvironmentStateKeys.MOTION_DETECTED.equals(key) && Boolean.TRUE.equals(newValue)) {
            String location = (String) environmentState.getState(EnvironmentStateKeys.MOTION_LOCATION);
            handleMotionDetected(location);
        }
    }
    private void handleMotionDetected(String location){
        if(location == null){
            return;
        }

        LocalDateTime timestamp = LocalDateTime.now();
        MotionEvent event = new MotionEvent(location,timestamp);

        locationHistory.computeIfAbsent(location, k -> new ArrayList<>()).add(event);

        LOGGER.info("Motion detected at "+location+ " at "+timestamp);

        environmentState.updateState(EnvironmentStateKeys.MOTION_TIMESTAMP,timestamp);

        if(isActivitySuspicious(location)){
            LOGGER.warning("Suspicious activity detected at "+location);
            environmentState.updateState(EnvironmentStateKeys.NOTIFICATION_EVENT,"Suspicious activity at "+location);
        }
    }

    /**
     * Determines if recent activity in a location is suspicious
     * based on frequency of events
     * @param location the location to check
     * @return true if activity is suspicious
     */

//    If motion is detected too frequently in the last 5 minutes, it is flagged as suspicious.
//    The threshold for suspicion is configurable via suspiciousThreshold (e.g., 3+ events within 5 minutes).
    public boolean isActivitySuspicious(String location) {
        List<MotionEvent> events = locationHistory.getOrDefault(location, Collections.emptyList());
        if (events.size() < suspiciousThreshold) return false;

        // Get the most recent events
        int eventsToCheck = Math.min(suspiciousThreshold, events.size());
        List<MotionEvent> recentEvents = events.subList(events.size() - eventsToCheck, events.size());

        // Check if these events occurred within a short time window (e.g., 5 minutes)
        LocalDateTime earliest = recentEvents.get(0).getTimestamp();
        LocalDateTime latest = recentEvents.get(recentEvents.size() - 1).getTimestamp();

        return latest.minusMinutes(5).isBefore(earliest);
    }

    /**
     * Get motion history for a specific location
     * @param location the location to get history for
     * @return the list of motion events
     */
    public List<MotionEvent> getMotionHistory(String location) {
        return new ArrayList<>(locationHistory.getOrDefault(location, Collections.emptyList()));
    }

    /**
     * Clear motion history for a location
     * @param location the location to clear
     */
    public void clearHistory(String location) {
        locationHistory.remove(location);
    }

    /**
     * Clear all motion history
     */
    public void clearAllHistory() {
        locationHistory.clear();
    }


}
