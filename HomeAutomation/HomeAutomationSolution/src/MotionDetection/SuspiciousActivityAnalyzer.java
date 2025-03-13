package MotionDetection;

import java.time.LocalTime;
import java.util.List;

// Analyzes motion history to detect unusual activity
public class SuspiciousActivityAnalyzer {
    public boolean isSuspicious(List<MotionEvent> history) {
        for (MotionEvent event : history) {
            LocalTime time = event.getTimestamp().toLocalTime();
            if (time.isAfter(LocalTime.of(23, 0)) || time.isBefore(LocalTime.of(5, 0))) {
                return true; // Suspicious if detected late at night
            }
        }
        return false;
    }
}
