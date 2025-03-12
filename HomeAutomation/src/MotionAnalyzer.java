import java.util.Date;

public class MotionAnalyzer {

    private static final long SUSPICIOUS_HOURS_START = 23; // 11 PM
    private static final long SUSPICIOUS_HOURS_END = 5;    // 5 AM
    





    private boolean isNightTime(long timestamp) {
        // Simplified check
        long hour = (timestamp / 3600000) % 24;
        return hour >= SUSPICIOUS_HOURS_START || hour < SUSPICIOUS_HOURS_END;
    }

    public boolean analyzeMotion(MotionEvent event) {
        // Using Strategy pattern internally to determine if motion is suspicious
        if (isNightTime(event.getTimestamp())) {
            return new NightTimeAnalysisStrategy().isMotionSuspicious(event);
        } else {
            return new DaytimeAnalysisStrategy().isMotionSuspicious(event);
        }
    }



}
